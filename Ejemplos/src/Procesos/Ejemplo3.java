package Procesos;

import java.io.*; 

public class Ejemplo3 { 
	
	public  static void main(String[] args){ 
	
		Runtime r  = Runtime.getRuntime(); 
		String comando= "CMD /C DIR" ;
		Process p=null; 
		
		if (args .length < 1)  { 
			System.out.println("SE NECESITA UN NOMBRE DE FICHERO ... "); 
			System.exit(1); 
		}
		try{ 
			//fichero al que se enviar� la salida del programa Unsaludo 
			FileOutputStream fos = new FileOutputStream(args[0]); 
			PrintWriter pw  = new PrintWriter(fos); 
			p  =  r.exec(comando); 
			
			InputStream is = p.getInputStream(); 
			BufferedReader br = new BufferedReader(new  InputStreamReader(is)); 
			String linea; 
			while((linea = br.readLine()) !=null)  //lee la salida de Unsaludo 
			{ 
				System.out.println("INSERTO EN "+args[0]+" >"+linea); 
				pw.println(linea); //la inserta en el fichero 
			}
			br.close(); 
			pw. close(); 
		}
		catch(Exception e){ e.printStackTrace();}
		// COMPROBACION DE ERROR- O bien 1 -mal 
			int exitVal; 
			try { 
				exitVal = p.waitFor(); 
				System.out.println("Valor de Salida: "+ exitVal); 
			}
			catch (InterruptedException e){ e.printStackTrace ();} 
	}		
}//Ejemplo3 