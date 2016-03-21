package Red;

import java.io.*;
import java.net.*;

public class EchoMultiserver {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		System.out.println("arranca el servidor");
		try {

			 serverSocket = new ServerSocket(9998);
			while (true) {
				new echoThread(serverSocket.accept()).start();
			}
			//serverSocket.close();
		} catch (IOException ex) {
	
				

		}
	}
}