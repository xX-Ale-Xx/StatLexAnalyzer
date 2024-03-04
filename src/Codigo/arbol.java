/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.util.ArrayList;

/**
 *
 * @author Javier Avila
 */
public class arbol {
    public String lex;
    public ArrayList<arbol> hijos;
    public double result;

    public arbol(String lex) {
        this.lex = lex;
        this.hijos = new ArrayList();
    }
    
    public void addHijo(arbol hijo){
        this.hijos.add(hijo);
    }
    public void printArbol(arbol raiz){
        for(arbol hijo : raiz.hijos){
            printArbol(hijo);
        }
        System.out.println(raiz.lex);
    }
    
    public String getValor(ArrayList<nodoSym> TS, String nombre){
        for(nodoSym num: TS){
            if(num.getNombre().equals(nombre)){
                return num.getValor(); 
            }
  
        }
            return "Semantic Error";
    }
    
        public void run(arbol raiz, ArrayList<nodoSym> TS){
        for(arbol hijo : raiz.hijos){
            run(hijo, TS);
        }
        if(raiz.lex.equals("DEC") &&  raiz.hijos.size() == 11){
           
            nodoSym sym = new nodoSym(raiz.hijos.get(5).lex, "Variable",  raiz.hijos.get(2).lex, "Local", "", String.valueOf(raiz.hijos.get(8).result));
            TS.add(sym);
        }else if(raiz.lex.equals("DEC") &&  raiz.hijos.size() == 12){
            
            nodoSym sym = new nodoSym(raiz.hijos.get(6).lex, "Variable",  raiz.hijos.get(3).lex, "Local", "", String.valueOf(raiz.hijos.get(9).result));
            TS.add(sym);
        }
        else if(raiz.lex.equals("VALOR") &&  raiz.hijos.size() == 1){
            raiz.result = raiz.hijos.get(0).result;
        }else if(raiz.lex.equals("VALOR OP") &&  raiz.hijos.size() == 1){
            raiz.result = raiz.hijos.get(0).result;
        }
        else if (raiz.lex.equals("OPARIT")  &&  raiz.hijos.size() == 6){
            //operaciones aritmeticas
            if("sum".equalsIgnoreCase(raiz.hijos.get(0).lex)){
                raiz.result = raiz.hijos.get(2).result + raiz.hijos.get(4).result;
            } else  if("res".equalsIgnoreCase(raiz.hijos.get(0).lex)){
                raiz.result = raiz.hijos.get(2).result - raiz.hijos.get(4).result;
            }else  if("mul".equalsIgnoreCase(raiz.hijos.get(0).lex)){
                raiz.result = raiz.hijos.get(2).result * raiz.hijos.get(4).result;
            }else  if("div".equalsIgnoreCase(raiz.hijos.get(0).lex)){
                raiz.result = raiz.hijos.get(2).result / raiz.hijos.get(4).result;
            }else  if("mod".equalsIgnoreCase(raiz.hijos.get(0).lex)){
                raiz.result = raiz.hijos.get(2).result % raiz.hijos.get(4).result;
            }
         
        }else if(raiz.lex.equals("E") &&  raiz.hijos.size() == 1){
            try{
            raiz.result = Double.parseDouble(raiz.hijos.get(0).lex);
            }catch(Exception e){
                String val = this.getValor(TS, raiz.hijos.get(0).lex);
                if(val.equals("Semantic Error")){
                    System.out.println("Error semantico, variable no encontrada");
                }else{
                    System.out.println("viene un id"+ val);
                    raiz.result = Double.parseDouble(val);
                }
                
            }
            }
        else if(raiz.lex.equals("COD") &&  raiz.hijos.size() == 1){
            raiz.result = raiz.hijos.get(0).result;
        }else if(raiz.lex.equals("LC") &&  raiz.hijos.size() == 1){
             raiz.result = raiz.hijos.get(0).result;
            
        }else if(raiz.lex.equals("LC") &&  raiz.hijos.size() == 2){
             raiz.result = raiz.hijos.get(1).result;
            
        }
        else if (raiz.lex.equals("S")){
            
             raiz.result = raiz.hijos.get(1).result;
        }
    }
    
    @Override
    public String toString() {
        // Devuelve una representación significativa del objeto
        return this.lex; // Ajusta según tus necesidades
    }
}
