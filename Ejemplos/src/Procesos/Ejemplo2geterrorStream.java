package Procesos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ejemplo2geterrorStream {
	public static void main(String[] args){
		
	Runtime r  =  Runtime.getRuntime(); 
	String comando= "CMD /C DIRR"; 
	Process p= null; 
	try 
	{ 
	p = r.exec( comando ); 
	InputStream is = p.getInputStream(); // la clase process permite acceder al stream de salida del proceso mediante getInputStream
	BufferedReader br = new BufferedReader (new InputStreamReader (is)); 
	String  linea; 
	while((linea = br. readLine() ) !=null){  //lee una línea 
		System.out.println(linea); 
		}
	br.close(); 
	}catch (Exception e)  { 
		e.printStackTrace(); 	
		int exitVal; 
		try{ 
		exitVal = p.waitFor(); //waitFor hace que el proceso actual espere hasta que el subproceso representado por el objeto process finalice. Devuelve 0 si ha finalizado correctamente.
		System.out.println("Valor de Salida: " + exitVal ); 
		}
		catch (InterruptedException ex)  { 
		ex.printStackTrace(); 
		} 
	}
	
	try { 
		InputStream er = p.getErrorStream(); 
		BufferedReader brer = 
		new BufferedReader(new InputStreamReader(er)); 
		String liner = null; 
		while ((liner = brer.readLine()) != null){
			System.out.println("ERROR >"  + liner);
		}
	}catch(IOException ioe){ 
		ioe.printStackTrace();
	}
	}
}
