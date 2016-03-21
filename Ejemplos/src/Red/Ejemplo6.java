package Red;

import java.net.*;

public class Ejemplo6 {
	public static void main(String[] args) throws Exception {
	int Puerto  =  6000; // Puerto 
	ServerSocket Servidor= new ServerSocket(Puerto); 
	System.out.println ("Escuchando en "  + Servidor.getLocalPort()); 
	Socket cliente1= Servidor.accept(); //esperando a  un  cliente 
	//realizar acciones con cliente1 
	Socket  cliente2 = Servidor.accept();//esperando a  otro  cliente 
	//realizar acciones con cliente2 
	Servidor.close(); //cierro  socket servidor 
	}
}
