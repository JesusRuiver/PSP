package Hilos;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class SwingThread implements Runnable{

	private JFrame frame;
	private Thread hilo  = null; 
	private Font fuente;  //tipo de letra para la hora 
	private String horaActual = ""; 
	private JLabel lblReloj;

	public void run() { 
		Thread hiloActual = Thread.currentThread(); 
		while (hilo == hiloActual) { 
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
			Calendar  cal= Calendar.getInstance(); 
			horaActual = sdf.format(cal.getTime()); 
			this.lblReloj.setText(horaActual);
			try { 
			Thread.sleep(1000); 
			} catch (InterruptedException e)  {}
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingThread window = new SwingThread();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingThread() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblReloj = new JLabel("Hora");
		frame.getContentPane().add(lblReloj, BorderLayout.CENTER);
		
		if (hilo == null){
			//crea el hilo 
			hilo= new Thread(this); 
			hilo.start(); //lanza  el hilo
		}
	}

}
