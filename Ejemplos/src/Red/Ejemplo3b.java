package Red;

import java.net.*;
import java.io.*;

public class Ejemplo3b {

	public static void main(String[] args) {
		URL url = null;
		URLConnection urlCon = null;
		try {
			url = new URL("http://localhost/ejemplo4/vernombre.php");
			urlCon = url.openConnection();
			BufferedReader in;
			InputStream inputStream = urlCon.getInputStream();
			in = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
		} //
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// EjemplolurlCon
}