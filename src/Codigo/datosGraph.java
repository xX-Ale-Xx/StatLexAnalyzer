/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

public class datosGraph {
    private String nombre;
    private String tipo;
    private Object valor;
    private String f;
    private String c;

    public datosGraph(String nombre, String tipo, Object valor, String f, String c) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
        this.f=f;
        this.c=c;
    }
    
     public datosGraph() {
        
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }
    
    
}
