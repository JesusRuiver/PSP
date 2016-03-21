package Hilos;

class HiloA extends Thread { 

	private Contador contador; 
	
	public  HiloA(String  n,  Contador e) { 
	setName(n); 
	contador = e; 
	}
	/*
	public void run() {
		for  (int  j  =  0;  j  < 300;  j++)  { 
			contador.incrementa();  //incrementa el contador 
			try { 
				sleep(100); 
			} catch(InterruptedException e)  {} 
		}
		System.out.println(getName()  + "  contador vale "  + contador .getValor ());
	} 
	*/
	//Synchronized
	
		public void run() {
		synchronized (contador)  {
			for  (int  j  =  0;  j  < 300;  j++)  { 
				contador.incrementa();  //incrementa el contador 
				//borramos el sleep, ya no nos hace falta
			}
			System.out.println(getName()  + "  contador vale "  + contador .getValor ());
		}
	} 
	
	
}		// FIN HILOA
