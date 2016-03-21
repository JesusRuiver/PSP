package servicios;

import java.io.*;
import org.apache.commons.net.ftp.*;

public class SubirFichero {
	public static void main(String[] args) {
		FTPClient cliente = new FTPClient(); // cliente
		String servFTP = "localhost";
		String usuario = "javier";
		String clave = "javier";
		try {
			System.out.println("Conectandose a " + servFTP);
			cliente.connect(servFTP);
			boolean login = cliente.login(usuario, clave);
			String direc = "/NUEVODIREC";
			if (login) {
				cliente.changeWorkingDirectory(direc);
				cliente.setFileType(FTP.BINARY_FILE_TYPE);
				// stream de entrada con el fichero a subir
				BufferedInputStream in = new BufferedInputStream(new FileInputStream("C:\\Users\\Javier\\Documents\\Proyectos\\Ejemplos\\servicios\\TEXTO1.txt"));
				cliente.storeFile("TEXTO1.txt", in);
				System.out.println("Subido txt");
				// stream de entrada con el fichero a subir
				in = new BufferedInputStream(new FileInputStream("C:\\Users\\Javier\\Documents\\Proyectos\\Ejemplos\\servicios\\Homi.jpg"));
				cliente.storeFile("Homi.jpg", in);
				System.out.println("Subido jpg");
				in.close(); // cerrar flujo
				cliente.logout(); // logout del usuario
				cliente.disconnect();
				System.out.println("Adios!");
			} // desconexión del servidor
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}