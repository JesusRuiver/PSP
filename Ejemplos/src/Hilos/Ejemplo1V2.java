package Hilos;

public class Ejemplo1V2 extends Thread{
	private int c; //contad;r de cada hilo 
	private int hilo;
	//Constructor
	public Ejemplo1V2(int hilo) { 
		this.hilo=hilo; 
		System.out.println("CREANDO HILO:"+ hilo); 
	}
	//metodo run 
	public void run(){
		c=0; 
		while (c<=5){
			System.out.println("Hilo:" +hilo+ " C = "  + c);
			c++; 
		}
	}
}
