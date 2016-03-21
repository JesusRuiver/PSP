package Red;

import java.io.*;
import java.net.*;

public class EchoClient {
	public static void main(String[] args) {
		try {

			Socket clientSocket = new Socket("localhost", 9998);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			System.out.println("Enviando: ¡¡ ¡ ¡ Ecooo!!!!");
			out.println("¡ ¡ ¡ ¡Ecooo!!!!");
			System.out.println("Recibiendo: " + in.readLine());
			out.close();
			in.close();
			clientSocket.close();
			
		} catch (UnknownHostException e) {
		} catch (IOException ex) {
		}
	}
}
