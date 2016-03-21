package Red;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class Ejercicio3Servidor {

	public static void main(String[] args) {
		ServerSocket servidor; //Socket servidor
		Socket cliente; //Socket cliente

		PrintStream  ps; //Canal de Escritura
        BufferedReader  br; //Canal de Lectura

        String mensajeRecibir;
        String  mensajeEnviar;

        System.out.println("Arranco el servidor");

        try {
        	//Creo el socket server
        	servidor = new ServerSocket (9999);
        	
        	mensajeEnviar = "";
        	
        	//Invoco el metodo accept del socket servidor, me devuelve una referencia al socket cliente
    		cliente = servidor.accept();

        	while(true) {
        		//Obtengo una referencia a los canales de escritura y lectura del socket cliente
        		br = new BufferedReader (new InputStreamReader(cliente.getInputStream()));
        		ps = new PrintStream  (cliente.getOutputStream());

        		// Instanciamos un calendario
        		Calendar calendario = Calendar.getInstance();
        		
        		// Recibimos el mensaje del cliente
        		mensajeRecibir = br.readLine();
        		System.out.println("Mensaje recibido del cliente: " + mensajeRecibir);
        		
        		mensajeEnviar = "Servidor[hora: " + calendario.get(Calendar.HOUR_OF_DAY)+":"+calendario.get(Calendar.MINUTE) + "]: " + mensajeRecibir;
        		
        		// Enviamos el mensaje al cliente
        		ps.println(mensajeEnviar);
        		
        		System.out.println("Mensaje enviado al cliente: " + mensajeEnviar);
			}
		} catch (IOException  e) {
			System .out.println("No puedo crear el socket");
		}
	}

}
