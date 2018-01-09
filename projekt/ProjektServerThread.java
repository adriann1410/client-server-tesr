package projekt;

import java.io.ObjectOutputStream;

import java.net.Socket;

public class ProjektServerThread extends Thread {
	Socket Socket;

	public ProjektServerThread(Socket socket) {
		super(); 
		Socket = socket;
	}

	public void run() 
	{
		try {
						
			String pytania[] = new String[4];
			pytania[0] = "a srasz?";
			pytania[1] = "ma pan dowód?";
			pytania[2] = "co tam gówniaki?";
			pytania[3] = "wiertara";
			
			String[] odpowiedzi1 = new String[4];
			odpowiedzi1[0] = "tak";
			odpowiedzi1[1] = "nie";
			odpowiedzi1[2] = "nie wiem";
			odpowiedzi1[3] = "co";
			
			Pytanie pyt1 = new Pytanie("a srasz", odpowiedzi1);
			
			
			
			ObjectOutputStream out2 = new ObjectOutputStream(Socket.getOutputStream());				
				out2.writeObject(pyt1);

								
			
			Socket.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
