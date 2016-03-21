package Hilos;

public class TortugaThread extends Thread
{
	public void run(){
		int i=0;
		System.out.println("Comienza la Tortuga.");
		while(i<5)
		{
			try
			{
				Thread.sleep(5000);
				System.out.println("Tortuga."+i);
			}
		catch(InterruptedException ex){}
		i++;
		}
		System.out.println("Termina la Tortuga.");
	}
}