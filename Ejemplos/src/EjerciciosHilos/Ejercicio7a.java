package EjerciciosHilos;

public class Ejercicio7a extends Thread{

	public void run(){
		int i = 0;
		while(i<5){
			
			System.out.println(this.getName() + " " + i );
			i++;
		}
	}
}
