package Hilos;

class HiloB extends Thread { 

	private Contador contador; 
	
	public  HiloB(String  n,  Contador e) { 
	setName(n); 
	contador = e; 
	}
/*	
	public void run() {
		for  (int  j  =  0;  j  < 300;  j++)  { 
			contador.decrementa();  //decrementa el contador 
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
				contador.decrementa();  //decrementa el contador 
				//borramos el sleep, ya no nos hace falta
			}
			System.out.println(getName()  + "  contador vale "  + contador .getValor ());
		}
	} 
	
}		// FIN HILOA