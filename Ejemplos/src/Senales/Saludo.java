package Senales;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Saludo {
   
    public Saludo(){       
    }
   
    /* Si no es jefe, el empleado va a quedar esperando a que llegue el jefe
    Se hace wait de el hilo que esta corriendo y se bloquea, hasta que
    se le avise que ya puede saludar*/
    public synchronized void saludoEmpleado(String nombre){
        try {
            wait();
            System.out.println("\n"+nombre.toUpperCase() + "-: Buenos días jefe.");
        } catch (InterruptedException ex) {
            Logger.getLogger(Saludo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    //Si es jefe, saluda y luego avisa a los empleados para que saluden
    // El notifyAll despierta a todos los hilos que esten bloqueados
    public synchronized void saludoJefe(String nombre){
        System.out.println("\n****** "+nombre + "-: Buenos días empleados. ******");
        notifyAll();
    }    
}