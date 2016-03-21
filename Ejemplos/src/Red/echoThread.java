package Red;

import java.io.*;
import java.net.*;

public class echoThread extends Thread {

	private Socket clientSocket = null;

	public echoThread(Socket param) {
		this.clientSocket = param;
	}

	public void run() {
		try {

			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputline = in.readLine();
			System.out.println("Recibiendo: " + inputline);
			String outputLine = "SERVIDOR"+inputline.toUpperCase();
			System.out.println("Enviando:" + outputLine);
			out.println(outputLine);
			out.close();
			in.close();
			clientSocket.close();
		} catch (IOException ex) {
		}
	}
}