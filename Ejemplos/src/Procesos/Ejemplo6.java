package Procesos;

import java.io.File; 
import java.io.IOException;

public class Ejemplo6 {
	public static void main(String args[])  throws IOException { 
	ProcessBuilder pb = new ProcessBuilder("CMD","/C" ,"DIR"); 
	
	File fOut = new File("C:/Users/Javier/Documents/Proyectos/Ejemplos/salida.txt"); 
	File fErr = new File("C:/Users/Javier/Documents/Proyectos/Ejemplos/error.txt"); 
	pb.redirectOutput(fOut); 
	pb.redirectError(fErr); 
	pb.start(); 
	}
}// Ejemplo6
