package Hilos;

public class Tac implements Runnable{
	
	public void run(){
		try
		{
			Thread.sleep(1000);
			while (true){
			
				Thread.sleep(2000);
				System.out.println("TAC");
				
			}
		}catch(InterruptedException ex){}		
	}
}
