package seguridad;

public class Ejemplo1 {
	public static void main(String[] args) {
		// propiedades de sistema en un array
		String t[] = { "java.class.path", 
				"java.home", 
				"java.vendor", 
				"java.version", 
				"os.name",
				"os.version", 
				"user.dir", 
				"user.home", 
				"user.name" };
		for (int i = 0; i < t.length; i++) {
			System.out.print(" Propiedad :" + t[i]);
			try {
				String s = System.getProperty(t[i]); // valor de la propiedad
				System.out.println(" \t ==> " + s);
			} catch (Exception e) {
				System.err.println("\n\tExcepción " + e.toString());
			}
		} // for
	}// main

}// ..Ejemplo1