package Procesos;
import  java.io.*; 
public class Ejemplo4 { //Ejemplo de regreso al futuro

	
	public static void main(String[]  args) {
	Runtime r  = Runtime.getRuntime(); 
	String comando="CMD /C  DATE "; 
	Process p=null; 
	
	try{ 
		p  = r.exec( comando); 
		//escritura-- envia entrada a  DATE 
		OutputStream os= p.getOutputStream(); 
		os.write ("20-10-15" .getBytes()); 
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
