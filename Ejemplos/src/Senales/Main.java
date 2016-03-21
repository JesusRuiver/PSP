package Senales;

public class Main {
	   
    public static void main(String[] args) {
       
        // Objeto en comun, se encarga del wait y notify
        Saludo s = new Saludo();
       
        /*Instancio los hilos y le paso como parametros:
         *
         * El Nombre del Hilo(en este caso es el nombre del personal)
         * ----El objeto en comun (Saludo)----
         * Un booleano para verificar si es jefe o empleados
         *
        */       
        Personal Empleado1 = new Personal("Pepe", s, false);
        Personal Empleado2 = new Personal("José", s, false);
        Personal Empleado3 = new Personal("Pedro", s, false);
        Personal Jefe1 = new Personal("JEFE", s, true);
       
             //Lanzo los hilos       
            Empleado1.start();           
            Empleado2.start();           
            Empleado3.start(); 
            try{
            	Thread.sleep(1000);
            }catch (Exception e){}
            Jefe1.start();

    }
}
