package Hilos;

public class Ejemplo6b {

	public static void main(String[] args){
	Ejemplo6 t1 = new Ejemplo6();
	t1.setName("Thread1");
	//Jugamos con la prioridad
	t1.setPriority(Thread.MAX_PRIORITY);
	Ejemplo6 t2 = new Ejemplo6();
	t2.setName("Thread2");
	//Jugamos con la prioridad
	t2.setPriority(Thread.MIN_PRIORITY);
	t2.start();
	t1.start();

	}
}