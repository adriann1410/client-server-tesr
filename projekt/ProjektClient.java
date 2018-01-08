package projekt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ProjektClient {
	
	private int port = 8000;
	Socket socket;
	String pytania[] = new String[4];
	int UID;
	
	public ProjektClient(){
		try {
			 socket = new Socket("127.0.0.1", port);
		}
		 catch (Exception e) {
			System.err.println(e);
			}
		
		
		}
	
	
	public String[] pobierzPytania(){
		
		BufferedReader in;
		String str;
		
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				int i = 0;
				while ((str = in.readLine()) != null) {
				pytania[i] = str;
				//System.out.println(socket.getInetAddress() + " : " + str);
				i++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
			}
			return pytania;
	}
	
	
	public void zamknijPo³¹czenie(){
		try{
		socket.close();
		}catch(IOException e) {
		 // TODO Auto-generated catch block
			System.err.println(e);
		}
	}
	
	
	public static void main(String args[]) {
		
			ProjektClient klient = new ProjektClient();
			klient.pobierzPytania();
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
