
package com.portfoliodl.DL.Security.Controller;

/**
 *
 * @author Diego Luna
 */
public class Mensaje {
        
    private String mensaje;
    
    //Constructores
    
    public Mensaje(){
    }
    
    public Mensaje(String mensaje){
        this.mensaje = mensaje;
    }
    
    //Get y set

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
