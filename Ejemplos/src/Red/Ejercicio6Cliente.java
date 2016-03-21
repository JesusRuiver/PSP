package Red;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Ejercicio6Cliente extends JFrame {

	private static int contador = 0;	// Es una copia del contador del hilo
	private JLabel lblInfo;

	private JPanel contentPane;
	private JLabel lblValorActual;
	private JButton btnIncrementa;
	
	private static BufferedReader brServidor;	// Recoge la información que llega del servidor
	private static PrintStream ps;	// Envía información al servidor
	
	private Socket socketCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio5Cliente frame = new Ejercicio5Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejercicio6Cliente() {
		construirVentana();
		actualizaContador();
		cargarStream();
	}

	private void construirVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 422, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);		
		
		lblValorActual = new JLabel();
		contentPane.add(lblValorActual, BorderLayout.NORTH);
		
		btnIncrementa = new JButton("Incrementa");
		btnIncrementa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				incrementarContador();
				actualizaContador();
			}
		});
		contentPane.add(btnIncrementa, BorderLayout.CENTER);
	}

	private void incrementarContador() {
		try {
			ps.println(1);
			contador = Integer.parseInt(brServidor.readLine());
		} catch (IOException e) {e.printStackTrace();}
	}

	private void actualizaContador() {
		lblValorActual.setText("PUNTUACIÓN: " + contador);
	}

	private void cargarStream() {
		try {
			socketCliente = new Socket("localhost", 9998);
			
			brServidor = new BufferedReader (new InputStreamReader(socketCliente.getInputStream()));
			ps = new PrintStream(socketCliente.getOutputStream(), true);
			
			System.out.println("Streams cargados");
		} catch (UnknownHostException e) {}
		catch (IOException e){}
	}
}
