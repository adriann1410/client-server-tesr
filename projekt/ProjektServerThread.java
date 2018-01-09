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
			
			String[] odpowiedzi2 = new String[4];
			odpowiedzi2[0] = "tak";
			odpowiedzi2[1] = "nie";
			odpowiedzi2[2] = "nie wiem";
			odpowiedzi2[3] = "co";
			
			String[] odpowiedzi3 = new String[4];
			odpowiedzi3[0] = "tak";
			odpowiedzi3[1] = "nie";
			odpowiedzi3[2] = "nie wiem";
			odpowiedzi3[3] = "co";
			
			String[] odpowiedzi4 = new String[4];
			odpowiedzi4[0] = "tak";
			odpowiedzi4[1] = "nie";
			odpowiedzi4[2] = "nie wiem";
			odpowiedzi4[3] = "co";
			
			Pytanie pyt1 = new Pytanie(pytania[0], odpowiedzi1);
			Pytanie pyt2 = new Pytanie(pytania[1], odpowiedzi2);
			Pytanie pyt3 = new Pytanie(pytania[2], odpowiedzi3);
			Pytanie pyt4 = new Pytanie(pytania[3], odpowiedzi4);
			
			Pytanie[] listapyt = {pyt1, pyt2, pyt3, pyt4};
			
			
			ObjectOutputStream out2 = new ObjectOutputStream(Socket.getOutputStream());				
				out2.writeObject(listapyt);
			
								
			
			Socket.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
