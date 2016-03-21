package Hilos;

import  java.awt.*;
import  java.applet. *; 
import java.text.SimpleDateFormat; 
import java.util. *; 

public class AppletThread extends Applet implements Runnable{ 
	
	private Thread hilo  = null; 
	private Font fuente;  //tipo de letra para la hora 
	private String horaActual = ""; 
	
	public void init() {
		fuente= new Font("Verdana", Font.BOLD, 26); 
		setBackground(Color. yellow);//color de fondo 
	} 
	public void start() { 
		if (hilo == null){
			//crea el hilo 
			hilo= new Thread(this); 
			hilo.start(); //lanza  el hilo
		}
	}

	public void run() { 
		Thread hiloActual = Thread.currentThread(); 
		while (hilo == hiloActual) { 
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
			Calendar  cal= Calendar.getInstance(); 
			horaActual = sdf.format(cal.getTime()); 
			repaint();  //actualizar contenido del applet 
			try { 
			Thread.sleep(1000); 
			} catch (InterruptedException e)  {}
		}
	}
	
	public void stop() {
		//hilo = null;
	}
	
	public  void paint(Graphics g)  {
		g.clearRect(1, 1, getSize().width, getSize().height);
		
		g.setFont(fuente); //fuente 
		g.drawString(horaActual,  20,  50);//muestra la hora 
	}
	
}
	
	
	