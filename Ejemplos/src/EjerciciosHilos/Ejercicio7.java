package EjerciciosHilos;


public class Ejercicio7 {

	public static void main(String[] args){
			
	Ejercicio7a t1 = new Ejercicio7a();
	System.out.println("Ejecutando: Uno");
	t1.setName("Uno:");
	//Jugamos con la prioridad
	t1.setPriority(1);
	
	Ejercicio7a t2 = new Ejercicio7a();
	System.out.println("Ejecutando: Dos");
	t2.setName("Dos:");
	//Jugamos con la prioridad
	t2.setPriority(Thread.NORM_PRIORITY);
	
	Ejercicio7a t3 = new Ejercicio7a();
	System.out.println("Ejecutando: Tres");
	t3.setName("Tres:");
	//Jugamos con la prioridad
	t3.setPriority(3);
	
	Ejercicio7a t4 = new Ejercicio7a();
	System.out.println("Ejecutando: Cuatro");
	t4.setName("Cuatro:");
	//Jugamos con la prioridad
	t4.setPriority(4);
	
	Ejercicio7a t5 = new Ejercicio7a();
	System.out.println("Ejecutando: Cinco");
	t5.setName("Cinco:");
	//Jugamos con la prioridad
	t5.setPriority(5);
	
	
	t1.start();
	t2.start();
	t3.start();
	t4.start();
	t5.start();
	
	
	}
}