package Red;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ejercicio3Cliente extends JFrame {
	
	private String mensajes = "";	// Guarda todos los mensajes

	private JPanel contentPane;
	private JTextField txtMensaje;
	private JTextArea lblResultado;
	
	private PrintStream  ps; //Canal de Escritura
    private BufferedReader  br; //Canal de Lectura
    private Socket cliente;
    private String host;
    private int puerto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio3Cliente frame = new Ejercicio3Cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ejercicio3Cliente() throws Exception{
		cargarCliente();
		cargarCanalesComunicacion();
		
		construirVentana();
	}

	private void cargarCliente() throws Exception{
		host = "localhost";
		puerto = 9999;
		cliente = new Socket(host, puerto);
		System.out.println("Cliente iniciado.");
	}
	
	private void cargarCanalesComunicacion() throws Exception{
		// Ligamos el canal de lectura del cliente con el de escritura del socket
		br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
		// Ligamos el canal de escritura del cliente con el de lectura del socket
		ps = new PrintStream(cliente.getOutputStream());
		
		System.out.println("Canales de comunicación con el socket cargados");
	}

	/**
	 * Create the frame.
	 */
	private void construirVentana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtMensaje = new JTextField();
		txtMensaje.setToolTipText("Escribe un mensaje aquí");
		txtMensaje.setBounds(10, 11, 426, 20);
		contentPane.add(txtMensaje);
		txtMensaje.setColumns(10);
		
		lblResultado = new JTextArea("");
		lblResultado.setBounds(10, 42, 525, 209);
		lblResultado.setEditable(false);
		contentPane.add(lblResultado);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(446, 10, 89, 23);
		contentPane.add(btnEnviar);
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				enviarMensaje();
				recogerMensaje();
				txtMensaje.setText("");
			}
		});
	}
	
	public void enviarMensaje() {
		String mensaje = txtMensaje.getText();
		ps.println(mensaje);
		System.out.println("Mensaje enviado al servidor: " + mensaje);
	}
	
	private void recogerMensaje() {
		try {
			String respuesta = br.readLine();
			System.out.println("Mensaje del servidor recibido: " + respuesta);
			mensajes += respuesta + "\n";
			lblResultado.setText(mensajes);
		} catch (IOException e) {
			System.out.println("Error en la lectura de datos del cliente");
		}
	}
}
