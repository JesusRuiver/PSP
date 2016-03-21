package Procesos;

import java.io.*;

public class Ejercicio9 {

	public static void main(String[] args) {

		Runtime r = Runtime.getRuntime();
		String comando = "CMD /C tasklist /svc /fi \"imagename eq svchost.exe\"";
		Process p = null;
		String ruta = "SVCHOST.TXT";
		try {
			// fichero al que se enviará la salida del programa Unsaludo
			FileOutputStream fos = new FileOutputStream(ruta);
			PrintWriter pw = new PrintWriter(fos);
			p = r.exec(comando);

			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String linea;
			while ((linea = br.readLine()) != null) // lee la salida de Unsaludo
			{
				System.out.println("INSERTO EN " + ruta + " >" + linea);
				pw.println(linea); // la inserta en el fichero
			}
			br.close();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// COMPROBACION DE ERROR- O bien 1 -mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}