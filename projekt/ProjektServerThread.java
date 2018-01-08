package projekt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
			
//			BufferedReader in = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
			String pytania[] = new String[4];
			pytania[0] = "a srasz?";
			pytania[1] = "ma pan dowód?";
			pytania[2] = "co tam gówniaki?";
			pytania[3] = "wiertara";
			
			String[][] odpowiedzi = new String[4][4];
			odpowiedzi[0][0] = "tak";
			odpowiedzi[0][1] = "nie";
			odpowiedzi[0][2] = "nie wiem";
			odpowiedzi[0][3] = "co";
			
			odpowiedzi[1][0] = "ma pan dowód?";
			odpowiedzi[1][1] = "jedna z najwazniejszych spraw w parlamencie wuropejskim";
			odpowiedzi[1][2] = "nie wiem";
			odpowiedzi[1][3] = "nie";
					
			odpowiedzi[2][0] = "ma pan dowód?";
			odpowiedzi[2][1] = "jedna z najwazniejszych spraw w parlamencie wuropejskim";
			odpowiedzi[2][2] = "nie wiem";
			odpowiedzi[2][3] = "nie";
			
			odpowiedzi[3][0] = "ma pan dowód?";
			odpowiedzi[3][1] = "jedna z najwazniejszych spraw w parlamencie wuropejskim";
			odpowiedzi[3][2] = "nie wiem";
			odpowiedzi[3][3] = "nie";
			
			
			
			PrintWriter out = new PrintWriter(new OutputStreamWriter(Socket.getOutputStream()));
			for(String ask: pytania){
				System.out.println(ask);
				out.println(ask);
				out.flush();
			}
		
			
//			String str;
//			str = in.readLine();
//			while (!str.equals("exit")) {
//			
//			}
			Socket.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
