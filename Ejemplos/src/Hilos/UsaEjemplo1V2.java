package Hilos;

import Hilos.Ejemplo1V2;

public class UsaEjemplo1V2 {
	public static void main(String[]  args) {
		Ejemplo1V2 h  = null; 
		for  (int i  = 0;  i  < 3; i++) {
			h  = new Ejemplo1V2(i+1); //crear hilo 
			h.start();  //iniciar hilo 
		}
		System.out.println("3 HILOS CREADOS ... "); 
	}// main 
}// clase usa hilo 
