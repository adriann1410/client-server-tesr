package projekt;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ProjektClient {
	
	private int port = 8000;
	Socket socket;
	Pytanie pyt1;
	int UID;
	
	public ProjektClient(){
		try {
			 socket = new Socket("127.0.0.1", port);
		}
		 catch (Exception e) {
			System.err.println(e);
			}
		
		
		}
	
	
	public Pytanie pobierzDane(){
		
		try {

			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());						
			pyt1 = (Pytanie)in.readObject();
			
			} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return pyt1;
		
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
