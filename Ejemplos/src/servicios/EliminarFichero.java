package servicios;

import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class EliminarFichero {

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
				cliente.changeWorkingDirectory("/NUEVODIREC");
				cliente.setFileType(FTP.BINARY_FILE_TYPE);

				if (cliente.deleteFile("Homi.jpg"))
					System.out.println("Fichero eliminado . .. ");
				else
					System.out.println("No se ha podido elimi nar Fichero ... ");

				cliente.logout(); // logout del usuario
				cliente.disconnect();
			} // desconexión del servidor
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
