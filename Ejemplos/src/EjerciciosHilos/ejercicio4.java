package EjerciciosHilos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Button;

import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ejercicio4 {
	private Hilo h; 
	long CONTADOR = 0; 
	private boolean parar; 

	private JFrame frame;
	Label label = new Label("0");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio4 window = new ejercicio4();
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
	public ejercicio4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		label.setBounds(177, 36, 56, 64);
		label.setFont(new Font("Dialog", Font.PLAIN, 40));
		frame.getContentPane().add(label);
		
		Button button = new Button("Iniciar Contador");
		Button button_1 = new Button("Parar Contador");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button.setLabel("Continuar"); 
				if(e.getSource()==button) //comienzo 
				{ 
					if(h!=null && h.isAlive()) {}//Si el hilo está corriendo no hago nada. 
					else { //lo creo 
						h=new Hilo(); 
						h. start (); 
					} 
				}
			}
		});
		button.setBounds(64, 135, 111, 76);
		frame.getContentPane().add(button);
		
		
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parar=true;
			}
		});
		button_1.setBounds(232, 135, 103, 76);
		frame.getContentPane().add(button_1);
		
	}
	class Hilo extends Thread{
		public void run()  { 
			parar=false; 
			Thread hiloActual = Thread.currentThread(); 
			while (h  == hiloActual &&  !parar)  { 
				try { 
					Thread.sleep(500); 
				}catch (InterruptedException e) {
					e.printStackTrace(); 
				}
				label.setText(Long.toString((long)CONTADOR));
				CONTADOR++;
			}
		}
	}
}
