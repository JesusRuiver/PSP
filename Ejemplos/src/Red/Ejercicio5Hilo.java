package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Ejercicio5Hilo extends Thread{
	private Ejercicio5Contador contador;
	
	private Socket socket;
	private BufferedReader brCliente;	// Recoge la información que llega del cliente
	private PrintStream  ps;	// Envía la información al cliente
	
	public Ejercicio5Hilo(Socket socket, Ejercicio5Contador contador) {
		this.socket = socket;
		this.contador = contador;
	}
	public void run() {
			try {
				ps = new PrintStream(socket.getOutputStream(), true);
				brCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				String entrada = "";	// Es el mensaje recibido desde el cliente
				String salida = "";	// Es la salida que se va a enviar al cliente
				
				while (true) {
					// Espera a que se pulse el boton
					entrada = brCliente.readLine();
					contador.incrementaContador();	// Incrementamos el contador
					salida = "" + contador.getContador();

					ps.println(salida);	// Enviamos la salida
				}
			} catch (IOException e) {}
	}
}