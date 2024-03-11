/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

/**
 *
 * @author Javier Avila
 */
public class nodoSym {
       private String nombre;
   private String rol;
   private String tipo;
   private String entorno;
   private String pertenece_a;
   private Object valor;
   private String linea;
   private String columna;

    public nodoSym(String nombre, String rol, String tipo, String entorno, String pertenece_a, Object valor, String linea, String columna) {
        this.nombre = nombre;
        this.rol = rol;
        this.tipo = tipo;
        this.entorno = entorno;
        this.pertenece_a = pertenece_a;
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getColumna() {
        return columna;
    }

    public void setColumna(String columna) {
        this.columna = columna;
    }

   
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEntorno() {
        return entorno;
    }

    public void setEntorno(String entorno) {
        this.entorno = entorno;
    }

    public String getPertenece_a() {
        return pertenece_a;
    }

    public void setPertenece_a(String pertenece_a) {
        this.pertenece_a = pertenece_a;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

   
    

}
