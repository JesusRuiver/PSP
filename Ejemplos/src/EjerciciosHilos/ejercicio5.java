package EjerciciosHilos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ejercicio5 {
	private Hilo h1; 
	private Hilo h2;
	long CONTADOR = 0; 
	long CONTADOR2 = 0;
	private boolean parar, parar2; 

	private JFrame frame;
	JLabel label = new JLabel("0");
	JLabel label_1 = new JLabel("0");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio5 window = new ejercicio5();
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
	public ejercicio5() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		h1=new Hilo(); 
		h1.start(); 
		h2=new Hilo(); 
		h2.start();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnFinalizarHilo = new JButton("Finalizar Hilo 1");
		
		btnFinalizarHilo.setBounds(12, 13, 195, 25);
		frame.getContentPane().add(btnFinalizarHilo);
		
		JButton btnFinalizarHilo_1 = new JButton("Finalizar Hilo2");
		
		btnFinalizarHilo_1.setBounds(219, 13, 201, 25);
		frame.getContentPane().add(btnFinalizarHilo_1);
		
		JLabel lblHilo = new JLabel("Hilo1:");
		lblHilo.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblHilo.setBounds(86, 80, 103, 62);
		frame.getContentPane().add(lblHilo);
		
		JLabel lblHilo_1 = new JLabel("Hilo2:");
		lblHilo_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblHilo_1.setBounds(86, 155, 103, 62);
		frame.getContentPane().add(lblHilo_1);
		
		
		label.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label.setBounds(201, 80, 103, 62);
		frame.getContentPane().add(label);
		
		
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label_1.setBounds(201, 155, 103, 62);
		frame.getContentPane().add(label_1);
		
		btnFinalizarHilo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parar=true;
				btnFinalizarHilo.setText("Finalizado Hilo 1");
			}
		});
		btnFinalizarHilo_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parar2=true;
				btnFinalizarHilo_1.setText("Finalizado Hilo 2");
			}
		});
	}
	class Hilo extends Thread{
		public void run()  { 
			parar=false;
			parar2=false;
			Thread hiloActual = Thread.currentThread(); 
			while (h1  == hiloActual &&  !parar)  { 
				try { 
					Thread.sleep(500); 
				}catch (InterruptedException e) {
					e.printStackTrace(); 
				}
				label.setText(Long.toString((long)CONTADOR));
				CONTADOR++;
			}
			while (h2  == hiloActual &&  !parar2)  { 
				try { 
					Thread.sleep(500); 
				}catch (InterruptedException e) {
					e.printStackTrace(); 
				}
				label_1.setText(Long.toString((long)CONTADOR2));
				CONTADOR2++;
			}
		}
	}
}
