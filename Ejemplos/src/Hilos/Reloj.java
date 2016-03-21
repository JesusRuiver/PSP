package Hilos;

public class Reloj {
	public static void main(String[]  args) {
			
		System.out.println("Empieza el reloj ... "); 
		Tic h1  = null;
		Thread h2  = null;
		
		
		h1 = new Tic(); //crear hilo 
		h2 = new Thread(new Tac()); //crear hilo
		//h1.setPriority(1);
		//h2.setPriority(2);
		h1.start();  //iniciar hilo 
		h2.start();  //iniciar hilo 
	}// main 
}
