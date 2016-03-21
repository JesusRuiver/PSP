package Hilos;

public class Ejemplo2 extends Thread{ 
	public void run() { 
		System.out.println("Dentro del Hilo:" + this.getName()  + 
		", Prioridad:  "  + this.getPriority() + 
		",  ID:  "  + this.getId()) ; 
	} 


	public  static void main(String[] args){
		Ejemplo2 h  = null; 
		for  (int i  = 0;  i  < 3; i++)  { 
			h  = new Ejemplo2();  //crear hilo 
			h.setName("HILO-"+i); //damos nombre al  hilo 
			h.setPriority(i+1); //damos  prioridad 
			h.start();  //iniciar hilo 
			System.out.println("Informacion del "  + 
			h. getName ()  +" :  "+ h. toString () ) ; 
		}
		System.out .println("3 HILOS CREADOS ... "); 
	}// main 
}// clase 