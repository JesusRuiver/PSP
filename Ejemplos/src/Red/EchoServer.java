package Red;

import java.io.*;
import java.net.*;

public class EchoServer {

	public static void main(String[] args) {
		System.out.println("arranca el servidor");
		try {
			ServerSocket serverSocket = new ServerSocket(9998);
			Socket clientSocket = serverSocket.accept();
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String inputline = in.readLine();
			System.out.println("Recibiendo: " + inputline);
			String outputLine = inputline.toUpperCase();
			System.out.println("Enviando: " + outputLine);
			out.println(outputLine);
			out.close();
			in.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException ex) {
		}
	}
}
