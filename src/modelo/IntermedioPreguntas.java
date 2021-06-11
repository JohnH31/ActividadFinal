/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Usuario
 */
public class IntermedioPreguntas {
    
    private String pregunta;
    public String respuesta1 ="Hormigo";
    public String respuesta2 ="General Jose Maria Orellana";
    public String respuesta3 ="Francisco Perez Muñoz";
    public String respuesta4 ="Justo Rufino Barrios";
    public String respuesta5 ="Tecun Uman";

    public int intentos=0,aciertos=0,fallas=0;
    public int intentos1=0,aciertos1=0,fallas1=0;
    public int intentos2=0,aciertos2=0,fallas2=0;
    public int intentos3=0,aciertos3=0,fallas3=0;
    public int intentos4=0,aciertos4=0,fallas4=0;

    public IntermedioPreguntas() {
    }
     

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    
    
}
