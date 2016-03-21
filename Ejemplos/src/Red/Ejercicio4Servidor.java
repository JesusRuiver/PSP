package Red;

import java.io.IOException;
import java.net.ServerSocket;

public class Ejercicio4Servidor {

	public static void main(String[] args) {
		System.out.println("Arranca el servidor");
		ServerSocket socketServidor = null;
		Ejercicio4Contador contador = new Ejercicio4Contador();
		try {
			socketServidor = new ServerSocket(9998);
			while(true) {
				new Ejercicio4Hilo(socketServidor.accept(), contador).start();
			}
		} catch (IOException ex) {}
	}

}
