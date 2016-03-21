package EjerciciosHilos;

import java.applet.Applet; 
import java.awt. *; 
import java.awt.event.*; 

public class Ejercicio1 extends Applet implements ActionListener{

	private HiloContador hilo1;	
	private Button b1, b2;
	private Font fuente;
	boolean parar;
	long contador = 0;
	
	class HiloContador extends Thread{
		// Atributos y métodos
		//...				
				
		public void run(){
			parar=false; 
			Thread hiloActual = Thread.currentThread(); 
			while (this == hiloActual &&  !parar)  { 
				try { 
					Thread.sleep(500); 
				}catch (InterruptedException e) {
					e.printStackTrace(); 
				}
				repaint(); 
				contador++;
			}
		}
	}
	
	//-------------------------------------------------------
	
		
	public void init(){	
		setBackground(Color.yellow);//color de fondo 
		add(b1=new Button("Iniciar contador")); 
		b1.addActionListener(this); 
		add(b2=new Button("Parar contador"));
		b2.addActionListener(this); 
		fuente = new Font("Verdana", Font.BOLD,  26) ; //tipo letra
	}
	
	public void paint(Graphics g)  { 
		g.clearRect(0, 0,  400, 400); 
		g.setFont(fuente) ;//fuente 
		g.drawString(Long.toString((long)contador),80,100);  //--------------------------------ATENTO
	}
	
	
	//-------
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		b1.setLabel("Continuar"); 
		if(e.getSource()==b1) //comienzo 
		{ 
			if(hilo1!=null && hilo1.isAlive()) {}//Si el hilo está corriendo no hago nada. 
			else { //lo creo 
				hilo1=new HiloContador(); 
				hilo1. start (); 
			} 
		}else if(e.getSource()==b2){  //parada 
			parar = true; 
			}//actionPerformed 
	}
	
	public void stop() { 
		hilo1 = null; 
	}
}
