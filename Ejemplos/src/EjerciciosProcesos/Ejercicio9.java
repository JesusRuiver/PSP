package EjerciciosProcesos;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejercicio9 {
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		String comando = "tasklist /SVC";
		Process p = null;
		try {			
			p = r.exec(comando);
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			PrintWriter pw = new PrintWriter(new FileWriter("C:/Users/Javier/Documents/Proyectos/Ejemplos/svchost2.txt"));			
			
			String linea;
			while ((linea = br.readLine()) != null) { // lee una línea
				pw.println(linea);
			}
			br.close();
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
			// COMPROBACION DE ERROR- O bien- 1 mal
			int exitVal;
			try {
				exitVal = p.waitFor();
				System.out.println("Valor de Salida: " + exitVal);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}