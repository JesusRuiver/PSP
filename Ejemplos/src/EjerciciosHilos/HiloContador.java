package EjerciciosHilos;

import java.applet.Applet;

class HiloContador extends Thread{
	private long contador; 
	private Ejercicio2 ejer2;
	private boolean parar; 
	
	public HiloContador(Ejercicio2 ejer2,long contador){
		this.ejer2 = ejer2;
		this.contador = contador;
	}
	public void run()  { 
		parar=false; 
		Thread hiloActual = Thread.currentThread(); 
		while (this  == hiloActual &&  !parar)  { 
			try { 
				Thread.sleep(300); 
			}catch (InterruptedException e) {
				e.printStackTrace(); 
			}
			ejer2.repaint(); 
			contador++;
		}
		
		}
		public long getContador(){
		return contador;
	}
		public void isParar(boolean parar){
			this.parar = parar;
		}
		public boolean getParar(){
			return parar;
		}
}
