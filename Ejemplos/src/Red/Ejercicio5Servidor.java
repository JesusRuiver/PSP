package ejercicios;

import java.io.IOException;
import java.net.ServerSocket;

// La clase es un copia exacta de Ejercicio4Servidor
public class Ejercicio5Servidor {

	public static void main(String[] args) {
		System.out.println("Arranca el servidor");
		ServerSocket socketServidor = null;
		try {
			socketServidor = new ServerSocket(9998);
			Ejercicio5Contador contador = new Ejercicio5Contador();
			while(true) {
				new Ejercicio5Hilo(socketServidor.accept(), contador).start();
			}
		} catch (IOException ex) {}
	}

}
