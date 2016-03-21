package Red;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;

public class Ejercicio6Hilo extends Thread{
	private Ejercicio6Contador contador;
	
	private Socket socket;
	private BufferedReader brCliente;	// Recibe información del cliente
	private PrintStream  ps;	// Envía la información al cliente
	
	public Ejercicio6Hilo(Socket socket, Ejercicio6Contador contador) {
		this.socket = socket;
		this.contador = contador;
	}
	public void run() {
		try {
			ps = new PrintStream(socket.getOutputStream(), true);
			brCliente = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String salida = "";	// Es la salida que se va a enviar al cliente

			while (true) {
				if (brCliente.readLine().equals("1")) {
					contador.incrementaContador();	// Incrementamos el contador
					salida = "" + contador.getContador();

					ps.println(salida);	// Enviamos la salida
				}
			}
		} catch (IOException e) {}
	}
	public Ejercicio6Contador getContador() {
		return contador;
	}
}
