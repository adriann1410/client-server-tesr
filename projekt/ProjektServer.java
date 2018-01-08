package projekt;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ProjektServer {
	public static void main(String args[]) {
	
		int port = 8000;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(port);
			while (true) {
				Socket socket = serverSocket.accept();
				(new ProjektServerThread(socket)).start();
			}
		} catch (Exception e) {
			System.err.println(e);
		}finally{
			if(serverSocket != null)
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}

