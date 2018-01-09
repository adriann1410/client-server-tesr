package projekt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Statement;

public class ProjektServerThread extends Thread {
	Socket Socket;

	public ProjektServerThread(Socket socket) {
		super(); 
		Socket = socket;
	}

	public void run() 
	{
		
		Database bazaDanych = new Database();
		bazaDanych.checkDriver("com.mysql.jdbc.Driver");
		Connection con = bazaDanych.getConnection("jdbc:mysql://", "localhost", 3306, "root", "");
		Statement st = bazaDanych.createStatement(con);
		bazaDanych.executeUpdate(st, "USE projektBaza;");
		
		
		
		
		String[] pytania = bazaDanych.getPytania(bazaDanych.executeQuery(st, "select pytanie from pytania;"));
		String[] odpowiedzi1	= bazaDanych.getOdpowiedzi(bazaDanych.executeQuery(st, "SELECT odp1, odp2, odp3, odp4 FROM `odpowiedzi` WHERE id_pytania =" + 1 +";"));
		String[] odpowiedzi2	= bazaDanych.getOdpowiedzi(bazaDanych.executeQuery(st, "SELECT odp1, odp2, odp3, odp4 FROM `odpowiedzi` WHERE id_pytania =" + 2 +";"));
		String[] odpowiedzi3	= bazaDanych.getOdpowiedzi(bazaDanych.executeQuery(st, "SELECT odp1, odp2, odp3, odp4 FROM `odpowiedzi` WHERE id_pytania =" + 3 +";"));
		String[] odpowiedzi4	= bazaDanych.getOdpowiedzi(bazaDanych.executeQuery(st, "SELECT odp1, odp2, odp3, odp4 FROM `odpowiedzi` WHERE id_pytania =" + 4 +";"));
		String poprawneodp = bazaDanych.getKlucz(bazaDanych.executeQuery(st, "select poprawna_odp from klucz;"));
		int id = bazaDanych.getNewId(st);
		
		Pytanie pyt1 = new Pytanie(pytania[0], odpowiedzi1);
		Pytanie pyt2 = new Pytanie(pytania[1], odpowiedzi2);
		Pytanie pyt3 = new Pytanie(pytania[2], odpowiedzi3);
		Pytanie pyt4 = new Pytanie(pytania[3], odpowiedzi4);
		
		Pytanie[] listapyt = {pyt1, pyt2, pyt3, pyt4};
		
		String odpklienta = new String();
		try {
			//wysylanie pytan i opowiedzi			
			ObjectOutputStream out2 = new ObjectOutputStream(Socket.getOutputStream());				
				out2.writeObject(listapyt);
				
			//wysylanie id uzytkownika	
			PrintWriter sendid = new PrintWriter(new OutputStreamWriter(Socket.getOutputStream()));	
			sendid.println(String.valueOf(id));
			sendid.flush();	
						
				
			//pobieranie odpowiedzi klienta					
			BufferedReader fromclient = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
			String str;		
			str = fromclient.readLine();
			odpklienta = str;
			
			bazaDanych.executeUpdate(st, "INSERT INTO uzytkownicy VALUES(" + id + "," + odpklienta.charAt(0) + "," + odpklienta.charAt(1)
			+"," + odpklienta.charAt(2)+"," + odpklienta.charAt(3) + ");");
			
			//wysylanie bazy poprawnych odpowiedzi	
			PrintWriter baza = new PrintWriter(new OutputStreamWriter(Socket.getOutputStream()));	
			baza.println(String.valueOf(poprawneodp));
			baza.flush();	
				
				
																									
			if(str.equals("exit")){
				System.out.println("klient"+ id +"zamknal polaczenie");
			}
				
										
			Socket.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
