package servicios;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;

public class RenombrarFichero {

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

				// RENOMBRAR FICHEROS
				if (cliente.rename("TEXTO1.txt", "TEXTO1RENOMBRADO.txt"))
					System.out.println("Fichero renombrado ... ");
				else
					System.out.println("No se ha podido renombar el Fichero ... ");

				cliente.logout(); // logout del usuario
				cliente.disconnect();
			} // desconexión del servidor
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
