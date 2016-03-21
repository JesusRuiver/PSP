package EjerciciosProcesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio7 {
public static void main(String[] args) {
        
        String linea;
        try {
            Process p = null;
	    // p.waitFor(); // Para el ejercicio8
            Runtime r = Runtime.getRuntime();
            
            p = r.exec("java -jar ejercicio2.jar");
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            while ((linea = input.readLine()) != null) {
                System.out.println(linea);
            }
            input.close();
        } catch (IOException ex) {
            System.out.println("error");
        }
    }

}
