package Red;

import java.net.*;

public class Ejemplo2 {

	public static void main(String[] args) {
		URL url;
		try {
			System.out.println("Constructor simple para una URL:");
			url = new URL("http://docs.oracle.com/en/");
			Visualizar(url);
			System.out.println("Otro constructor simple para una URL:");
			url = new URL("http://localhost/PFC/gest/cli_gestion.php?S=3");
			Visualizar(url);
			System.out.println("Const.  para protocol o  +URL  +directorio:");
			url = new URL("http", "docs.oracle.corn", "/javase/7");
			Visualizar(url);
			System.out.println("Constructor para protocolo + URL + puerto + directorio:");
			url = new URL("http", "docs.oracle.com", 80, "/javase/7");
			Visualizar(url);
			System.out.println("Constructor para un objeto URL y  un directorio:");
			URL urlBase = new URL("http://docs.oracle.com/");
			url = new URL(urlBase, "/javase/7/docs/api/java/net/URL.html");
			Visualizar(url);
		} catch (MalformedURLException e) {
			System.out.println(e);
		}
	}// main

	private static void Visualizar(URL url) { 
	System. out.println("\t URL completa: " + url.toString()); 
	System.out.println("\t getProtocol(): " + url.getProtocol()); 
	System.out.println("\t getHost():  " + url.getHost());  
	System. out. println ("\t getPort () :  "  + url. getPort () ) ; 
	System.out.println("\t getFile(): " + url.getFile()); 
	System.out.println("\t getUserinfo():  "+ url.getUserInfo()); 
	System.out.println("\t getPath():  " + url .getPath()); 
	System. out. println ("\t getAuthority () :  "  + url.getAuthority()) ; 
	System.out.println("\t getQuery(): " + url.getQuery()); 
	System.out .println("=================================================="); 
	}// EjemplolURL

}
