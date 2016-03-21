package EjerciciosHilos;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class Ejercicio2 extends Applet implements ActionListener {
	private Font  fuente; 
	private Button bl,b2; //botones del Applet
	private HiloContador hilo;
	private HiloContador hilo2;
	
public void start() {
	int contador = 0;
	hilo=new HiloContador(this,contador); 
	hilo2=new HiloContador(this,contador); 
} 

public void init() { 
	add(bl=new Button("Inicializar Hilo1")); 
	bl.addActionListener(this); 
	add(b2=new Button("Inicializar Hilo2"));
	b2.addActionListener(this); 
	fuente = new Font("Verdana", Font.BOLD,  26) ; //tipo letra
}



public void paint(Graphics g)  { 
	g.clearRect(0, 0,  400, 400); 
	g.setFont(fuente) ;//fuente 
	g.drawString("Hilo1: " + Long.toString((long)hilo.getContador()),80,100); 
	g.drawString("Hilo2: " + Long.toString((long)hilo2.getContador()),80,150);
}

//para controlar que se pulsan los botones 
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==bl) { //comienzo 
		bl.setLabel("Finalizar Hilo1");
		
		if(hilo!=null && hilo.isAlive()) {
			hilo.isParar(true);
		}//Si el hilo está corriendo no hago nada. 
		else if(!hilo.getParar()){//Si el hilo no esta corriendo y no esta parado lo inicializo 
			hilo.start (); 
		}
		
	}else if(e.getSource()==b2){  //comienzo
		b2.setLabel("Finalizar Hilo2");
		if(hilo2!=null && hilo2.isAlive()) {
			hilo2.isParar(true);
		}//Si el hilo está corriendo no hago nada. 
		else if(!hilo2.getParar()){///Si el hilo no esta corriendo y no esta parado lo inicializo
			hilo2.start (); 	
		}
	}
}


}
