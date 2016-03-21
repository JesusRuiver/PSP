package Senales;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Personal extends Thread{
    String nombre;
    Saludo saludo;
    boolean esJefe;
   
    public Personal(String nombre, Saludo salu, boolean esJefe){
        this.nombre = nombre;
        this.saludo = salu;
        this.esJefe = esJefe;
    }
   
    public void run(){
        System.out.println(nombre + " llegó.");
        try {
            Thread.sleep(1000);
            //Verifico si es personal que esta es jefe o no
            if(esJefe){
                saludo.saludoJefe(nombre);
            }else{
                saludo.saludoEmpleado(nombre);
            }
           
        } catch (InterruptedException ex) {
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
