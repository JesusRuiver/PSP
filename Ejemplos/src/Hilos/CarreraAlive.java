package Hilos;

public class CarreraAlive {
	
	public static void main(String[] args){
	TortugaThread tortuga =new TortugaThread();
	Thread liebre =new Thread(new LiebreThread());
	System.out.println(tortuga.isAlive());
	System.out.println(liebre.isAlive());
	tortuga.start();
	liebre.start();
	System.out.println(tortuga.isAlive());
	System.out.println(liebre.isAlive());
	}
}
