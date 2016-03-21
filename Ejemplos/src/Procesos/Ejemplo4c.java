package Procesos;

import  java.io.*; 

public class Ejemplo4c {
	public static void main(String[]  args) {
	Runtime r  = Runtime.getRuntime(); 
	String comando="CMD /C java -classpath \"C:/Users/Javier/Documents/Proyectos/Ejemplos/bin\" Procesos.Ejemplo4b"; 
	Process p=null; 
	
	try{ 
		p  = r.exec( comando); 
		//escritura-- envia entrada a  DATE 
		OutputStream os= p.getOutputStream(); 
		os.write ("Hola Martin\n" .getBytes()); //NOTA: tienes que acabar la cadena en \n
		os.flush(); //vacia el buffer de salida 
		//lectura - - obtiene la salida de  DATE 
		InputStream is = p.getInputStream();
		BufferedReader br = new BufferedReader(new  InputStreamReader(is)); 
		String linea; 
		while((linea = br.readLine()) !=null ) 
		System.out.println(linea); 
		br.close(); 
		}catch (Exception e)  {  e.printStackTrace() ;} 
		// COMPROBACION DE ERROR- O bien 1 -mal 
		int exitVal ; 
		try { 
			exitVal =  p.waitFor(); 
			System.out.println("Valor de  Salida: " + exitVal); 
			} catch (InterruptedException e)  { 
			e.printStackTrace(); 
			} 
		}	
}
