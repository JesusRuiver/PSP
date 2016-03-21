package Red;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Ejercicio4Cliente {
	
	private static PrintStream ps;	// Env�a la informaci�n al servidor
    private static BufferedReader  brConsola;	// Recoge la informaci�n de la consola
    private static BufferedReader brServidor;	// Recoge la informaci�n que llega del servidor

	public static void main(String[] args) {
		try {
			Socket socketCliente = new Socket("localhost", 9998);
			
			ps = new PrintStream(socketCliente.getOutputStream(), true);
			brConsola = new BufferedReader(new InputStreamReader(System.in));
			brServidor = new BufferedReader (new InputStreamReader(socketCliente.getInputStream()));
			
			System.out.println("Escribe 'incrementa' para incrementar el contador");
			
			String mensaje = "";
			while(true) {
				mensaje = brConsola.readLine();	// Lee el mensaje de la consola
				ps.println(mensaje);	// Env�a el mensaje al servidor
				System.out.println("Contador: " + brServidor.readLine());	// Recibe la respuesta del servidor
			}
			
		} catch (UnknownHostException e) {}
		catch (IOException ex) {}
	}

}
