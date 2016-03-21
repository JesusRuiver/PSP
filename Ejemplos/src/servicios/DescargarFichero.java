package servicios;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class DescargarFichero {
	public static void main(String[] args) {
		FTPClient cliente = new FTPClient(); // cliente
		String servidor = "localhost"; 
		String user = "javier";
		String pasw = "javier";
		try {
			System.out.println("Conectandose a " + servidor);
			cliente.connect(servidor);
			boolean login = cliente.login(user, pasw);
			if (login) {
				// Descarga de fichero
				cliente.changeWorkingDirectory("/NUEVODIREC");
				cliente.setFileType(FTP.BINARY_FILE_TYPE);

				// stream de salida para recibir el fichero descargado
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream("C:\\Users\\Javier\\Desktop\\imagen.jpg"));
				if (cliente.retrieveFile("Homi.jpg", out))
					System.out.println("Recuperado correctamente ... ");
				else
					System.out.println("No se ha podido descargar ... ");
				out.close();

				cliente.logout(); // logout del usuario
				cliente.disconnect();
			} // desconexión del servidor
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
