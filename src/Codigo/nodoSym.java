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
   private String valor;

    public nodoSym(String nombre, String rol, String tipo, String entorno, String pertenece_a, String valor) {
        this.nombre = nombre;
        this.rol = rol;
        this.tipo = tipo;
        this.entorno = entorno;
        this.pertenece_a = pertenece_a;
        this.valor = valor;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
   
}