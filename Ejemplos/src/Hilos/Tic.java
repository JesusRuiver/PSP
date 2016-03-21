package Hilos;

public class Tic extends Thread{

	public void run(){
	
		while (true){
			try
			{
			Thread.sleep(2000);
			System.out.println("TIC");
			}catch(InterruptedException ex){}		
		}
	}
}
