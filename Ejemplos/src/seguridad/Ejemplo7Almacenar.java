package seguridad;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Ejemplo7Almacenar {
	public static void main(String[] args) {
		try {

			KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
			// SE INICIALIZA EL GENERADOR DE CLAVES
			SecureRandom numero = SecureRandom.getInstance("SHA1PRNG");
			keyGen.initialize(1024, numero);
			// SE CREA EL PAR DE CLAVES PRIVADA Y PÚBLICA
			KeyPair par = keyGen.generateKeyPair();
			PrivateKey clavepriv = par.getPrivate();
			PublicKey clavepub = par.getPublic();

			// GUARDAMOS LA CLAVE PRIVADA
			PKCS8EncodedKeySpec pk8Spec = new PKCS8EncodedKeySpec(clavepriv.getEncoded());
			// Escribir a fichero binario la clave privada
			FileOutputStream outpriv = new FileOutputStream("Clave.privada");
			outpriv.write(pk8Spec.getEncoded());
			outpriv.close();

			// GUARDAMOS LA CLAVE PÚBLICA
			X509EncodedKeySpec pkX509 = new X509EncodedKeySpec(clavepub.getEncoded());
			// Escribir a fichero binario la clave pública
			FileOutputStream outpub = new FileOutputStream("Clave.publica");
			outpub.write(pkX509.getEncoded());
			outpub.close();
			
			System.out.println("Claves generadas");

		} catch (NoSuchAlgorithmException el) {
			el.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// main

}
