package seguridad;

import java.io.*;
import java.security.MessageDigest;

public class Ejemplo6 {
	public static void main(String args[]) {
		try {
			FileInputStream fileout = new FileInputStream("DATOS.DAT");
			ObjectInputStream dataOS = new ObjectInputStream(fileout);
			Object o = dataOS.readObject();
			// Primera lectura, se obtiene el String
			String datos = (String) o;
			System.out.println("Datos:  " + datos);
			// Segunda lectura, se obtiene el resumen
			o = dataOS.readObject();
			byte resumenOriginal[] = (byte[]) o;
			MessageDigest md = MessageDigest.getInstance("SHA");
			// Se calcula el resumen del String leído del fichero
			md.update(datos.getBytes());// TEXTO A RESUMIR
			byte resurnenActual[] = md.digest(); // SE CALCULA EL RESUMEN
			// Se comprueban lo dos resúmenes
			if (MessageDigest.isEqual(resurnenActual, resumenOriginal))
				System.out.println("DATOS VÁLIDOS");
			else
				System.out.println("DATOS NO VÁLIDOS");
			dataOS.close();
			fileout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}// .. Ejemplo6