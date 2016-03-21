package Procesos;

public class Ejercicio8hola {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("SE NECESITA UN NOMBRE PARA MOSTRAR ... ");
			System.exit(1);
		}
		System.out.println(args[0]);
	}
}