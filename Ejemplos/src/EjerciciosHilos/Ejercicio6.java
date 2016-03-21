package EjerciciosHilos;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Ejercicio6 {

	private JFrame frame;
	private HiloContador hilo1,hilo2;
	private JButton btnParar1, btnParar2;
	private JLabel lblNumero1,lblNumero2;
	private Font fuente;
	private JLabel label;
	
	private long variable1, variable2  =0;
	
	
	public Ejercicio6() {
		initialize();
	}
	
	class HiloContador extends Thread{
		// Atributos y métodos
		//...			
		public long contador = 0;
		public boolean parar;
		public JLabel label;
		
		
		public HiloContador(long contador, JLabel label){
			this.contador = contador;
			this.label = label;
		}	
		
		public long getContador(){
			return contador;
		}
		
		public void parar(){
			parar = true;
		}
				
		public void run(){
			parar=false; 
			Thread hiloActual = Thread.currentThread(); 
			while (this == hiloActual &&  !parar)  { 
				try { 
					Thread.sleep(500); 
				}catch (InterruptedException e) {
					e.printStackTrace(); 
				}				
				contador++;
				label.setText(contador+"");
			}
		}		
	}
	
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 323, 78);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		
		
		lblNumero1 = new JLabel("");
		panel.add(lblNumero1);
		
		
		
		hilo1 = new HiloContador(13, lblNumero1);		
		
		
		btnParar1 = new JButton("Pausar h1");//----------------------------> BOTON1
		panel.add(btnParar1);
		btnParar1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(e.getSource()==btnParar1) //comienzo 
				{ 
					if (hilo1!=null && hilo1.isAlive()){
						variable1 = hilo1.getContador();
						hilo1.parar(); 
						btnParar1.setText("Continuar h1");
					}else{
						hilo1=new HiloContador(variable1, lblNumero1); 
						hilo1. start (); 
						btnParar1.setText("Pausar h1");
					}					
					
				}				
								
			}
		});
		
		btnParar2 = new JButton("Pausar h2");//----------------------------> BOTON2
		panel.add(btnParar2);
		btnParar2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnParar2) //comienzo 
				{ 
					if (hilo2!=null && hilo2.isAlive()){
						variable2 = hilo2.getContador();
						hilo2.parar(); 
						btnParar2.setText("Continuar h2");
					}else{
						hilo2=new HiloContador(variable2, lblNumero2); 
						hilo2. start (); 
						btnParar2.setText("Pausar h2");
					}				
					
				}		
			}
		});		
		
		
		lblNumero2 = new JLabel("");
		panel.add(lblNumero2);	
		hilo2 = new HiloContador(26, lblNumero2);
		
		hilo1.start();hilo2.start();
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					Ejercicio6 window = new Ejercicio6();
					window.frame.setVisible(true);					
					} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	
}

