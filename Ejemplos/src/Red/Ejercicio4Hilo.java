package Red;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Ejercicio4Hilo extends Thread{
	
	private Socket socket;
	private BufferedReader brCliente;	// Recoge la información que llega del cliente
	private PrintStream  ps;	// Envía la información al cliente
	private Ejercicio4Contador contador;
	
	public Ejercicio4Hilo(Socket socket, Ejercicio4Contador contador) {
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
					entrada = brCliente.readLine();
					
					if (entrada.equals("incrementa")) {	// El mensaje es correcto
						contador.incrementaContador();	// Incrementamos el contador
						salida = "" + contador.getContador();
					}
					else {	// El mensaje no es correcto
						salida = "ERROR";	// Enviamos ERROR
					}
					
					ps.println(salida);	// Enviamos la salida
				}
			} catch (IOException e) {}
	}
}
