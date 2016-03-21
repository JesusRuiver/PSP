package Red;


import java.io.IOException;
import java.net.ServerSocket;

public class Ejercicio6Servidor {
	private static Ejercicio6Hilo h1,h2,h3;

	public static void main(String[] args) {
		System.out.println("Arranca el servidor");
		ServerSocket socketServidor = null;
		try {
			socketServidor = new ServerSocket(9998);
			Ejercicio6Contador contador1 = new Ejercicio6Contador();
			Ejercicio6Contador contador2 = new Ejercicio6Contador();
			Ejercicio6Contador contador3 = new Ejercicio6Contador();
			
			System.out.println("Esperando jugadores");
			
			h1 = new Ejercicio6Hilo(socketServidor.accept(), contador1);
			System.out.println("Jugador 1 conectado");
			h2 = new Ejercicio6Hilo(socketServidor.accept(), contador2);
			System.out.println("Jugador 2 conectado");
			h3 = new Ejercicio6Hilo(socketServidor.accept(), contador3);
			System.out.println("Jugador 3 conectado");
			
			System.out.println("EMPIEZA EL JUEGO");
			
			h1.start();
			h2.start();
			h3.start();
			socketServidor.close();
			
			try {
				Thread.sleep(10000);
				System.out.println("Juego terminado");
				socketServidor.close();
			} catch (InterruptedException e) {e.printStackTrace();}
			
			// Determinamos el ganador
			int puntGanador = 0;
			String ganador = "";
			
			System.out.println("***PUNTUACIONES***");
			System.out.println("Jugador 1: " + contador1.getContador());
			System.out.println("Jugador 2: " + contador2.getContador());
			System.out.println("Jugador 3: " + contador3.getContador());
			
			if (contador1.getContador() >= puntGanador) {
				puntGanador = contador1.getContador();
				ganador = "Jugador 1";
			}
			if (contador2.getContador() >= puntGanador) {
				puntGanador = contador2.getContador();
				ganador = "Jugador 2";
			}
			if (contador3.getContador() >= puntGanador) {
				puntGanador = contador3.getContador();
				ganador = "Jugador 3";
			}
			System.out.println("¡¡¡El ganador es el " + ganador + "!!!");
			
		} catch (IOException ex) {}
	}
}
