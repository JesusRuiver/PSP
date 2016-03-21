package Hilos;

public class Carrera {
	
	public static void main(String[] args){
		//Notad la diferencia a la hora de crear el objeto hilo, dependiendo de si se usa Thread o Runable
		TortugaThread tortuga =new TortugaThread(); 
		Thread liebre =new Thread(new LiebreThread());
		System.out.println("EMPIEZA LA CARRERA..."); 
		tortuga.start();
		liebre.start();
	}
}
