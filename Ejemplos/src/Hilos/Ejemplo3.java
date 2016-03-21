package Hilos;

public class Ejemplo3 extends Thread{
	
	private boolean stopHilo = false; 
	
	public void pararHilo(){ 
		stopHilo = true; 
	}
	//metodo run 
	public void run() {
		while (!stopHilo) {
			System.out.println("En el hilo");
		} 
	}
	
	public static void main(String[]  args)  { 
		Ejemplo3 h  = new Ejemplo3 (); 
		h. start (); 
		for(int i=0;i<1000000; i++) {} ; //no hago nada 
		
		h.pararHilo();  //parar el hilo
		
	}
}
