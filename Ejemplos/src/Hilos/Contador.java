package Hilos;

class Contador {
	private int c = 0; //atributo contador
	Contador (int e) {this.c = e; }
	public void incrementa() {c = c+ 1; }
	public void decrementa() {c= c-1;}
	public int getValor() {return c; }
}// CONTADOR