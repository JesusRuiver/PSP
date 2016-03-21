package Procesos;

import java.io.*;
//Autor: David Martín Sousa
public class Ejercicio8 {
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("SE NECESITA UN NOMBRE PARA MOSTRAR ... ");
			System.exit(1);
		}
		Runtime r = Runtime.getRuntime();
		String rutaJava = ""; //Si no tienes la ruta de java en tu path de windows añadela aquí
		String rutaProyecto = new File("").getAbsolutePath();
		String paquete = Ejercicio7.class.getPackage().getName();
		String comando = "CMD /C "+ rutaJava + "java -classpath \""
						 + rutaProyecto + "\\bin\" " + paquete + ".Ejercicio8hola"+" "+args[0];
		System.out.println(comando);
		Process p = null;
		try {
			p = r.exec(comando);
			mostrarInputStream(p.getErrorStream());
			mostrarInputStream(p.getInputStream());
		} catch (Exception e) {
			e.printStackTrace();
			// COMPROBACION DE ERROR- O bien- 1 mal
			int exitVal;
			try {
				exitVal = p.waitFor();
				// waitFor hace que el proceso actual espere hasta que el subproceso
				// representado por el objeto process finalice.
				//Devuelve 0 si ha finalizado correctamente.
				System.out.println("Valor de Salida: " + exitVal);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private static void mostrarInputStream(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String linea;
		while ((linea = br.readLine()) != null) { // lee una línea
			System.out.println(linea);
		}
		br.close();
		
	}
}