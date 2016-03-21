package EjerciciosProcesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio8 {
	public static void main(String[] args) throws IOException {

		System.out.println("Introduce un nombre:");
		System.out.print("> ");
		InputStreamReader entrada = new InputStreamReader(System.in);
		BufferedReader teclado = new BufferedReader(entrada);
		String cadena = teclado.readLine();
		System.out.println(cadena);
	}
}
