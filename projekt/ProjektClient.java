package projekt;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ProjektClient {
	
	private int port = 8000;
	Socket socket;
	Pytanie pytania[];
	String odp;
	String bazaOdp;
	int UID;
	
	public ProjektClient(){
		try {
			 socket = new Socket("127.0.0.1", port);
		}
		 catch (Exception e) {
			System.err.println(e);
			}
		
		
		}
	
	
	public Pytanie[] pobierzDane(){
		
		try {

			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());						
			pytania = (Pytanie[])in.readObject();
			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return pytania;
		
	}

	public Socket pobierszSocket(){
		return socket;
	}
	
	public void przeslijOdp(String odp){
		try{
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));	
				out.println(odp);
				out.flush();
			}catch(IOException e) {
			 // TODO Auto-generated catch block
				System.err.println(e);
			}
	}
	
	
	public String pobierzBazeOdp(){
		BufferedReader fromclient;
		try {
			fromclient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str;		
			str = fromclient.readLine();
			bazaOdp = str;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bazaOdp;
	}
	
	public void zamknijPo³¹czenie(){
		try{
		PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));	
			out.println("exit");
			out.flush();
		socket.close();
		}catch(IOException e) {
		 // TODO Auto-generated catch block
			System.err.println(e);
		}
	}
	
	
	public static void main(String args[]) {
		
			ProjektClient klient = new ProjektClient();
			klient.zamknijPo³¹czenie();
		
		
//			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//			Scanner sc = new Scanner(System.in);
//			String str;
//			socket.setTcpNoDelay(true);
//			while(sc.hasNext()){
//				str = sc.nextLine();
//				out.println(str);
//				out.flush();
//				if(str.equals("exit")) break;
//				}
//			}
//			sc.close();
//			socket.close();
		
	}
}
