package Procesos;

import java.lang.*;

public class Ejemplo1{
	public static  void main(String[] args){
		Runtime r = Runtime.getRuntime(); 
		String comando= "NOTEPAD"; 
		Process p; 
		try{ 
		p = r.exec(comando);
		}catch (Exception e){ 
			System.out.println("Error en: "+comando ); 
			e.printStackTrace(); 
		} 
	} 
}
