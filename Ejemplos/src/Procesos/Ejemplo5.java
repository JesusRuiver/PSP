package Procesos;

import java.io.*;
import  java.util.*; 

public class Ejemplo5 { 
	
	public  static void main(String[] args){ 
		
			ProcessBuilder pb = new ProcessBuilder("CMD","/C" ,"DIR"); 
			try{
				Process p= pb.start(); 
				InputStream is = p.getInputStream(); 
				BufferedReader br = new BufferedReader(new InputStreamReader (is)); 
				String linea; 
				while((linea = br.readLine()) !=null) //lee la salida stándar 
					System.out.println(linea); 
				br.close(); 
			}
			catch(Exception e)  {  e.printStackTrace(); } 
		
	}

}// Ejemplo5