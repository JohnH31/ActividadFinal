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
public class Avanzado {

    private int num1;
    private int valor;
    private String respuesta;

    public int intentos = 0, aciertos = 0, fallas = 0;
    public int intentos1 = 0, aciertos1 = 0, fallas1 = 0;
    public int intentos2 = 0, aciertos2 = 0, fallas2 = 0;
    public int intentos3 = 0, aciertos3 = 0, fallas3 = 0;

    public Avanzado() {
    }
    

    public int obtenerAleatorio() {
        return (int) (Math.random() * 15);
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
