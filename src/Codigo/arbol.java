/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Javier Avila
 */
public class arbol {
    public String lex;
    public ArrayList<arbol> hijos;
    public Object result;

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
    
    public Object getValor(ArrayList<nodoSym> TS, String nombre){
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
        else if(raiz.lex.equals("DARR") &&  raiz.hijos.size() == 15){
           
            nodoSym sym = new nodoSym("@"+raiz.hijos.get(7).lex, "Variable",  raiz.hijos.get(3).lex, "Local", "", raiz.hijos.get(11).result);
            TS.add(sym);
        }
        else if(raiz.lex.equals("DARR") &&  raiz.hijos.size() == 14){
            
            nodoSym sym = new nodoSym("@"+raiz.hijos.get(6).lex, "Variable",  raiz.hijos.get(3).lex, "Local", "", raiz.hijos.get(10).result);
            TS.add(sym);
        }
        else if(raiz.lex.equals("LVAL") &&  raiz.hijos.size() == 1){
            ArrayList<Object> list = new ArrayList();
            list.add(raiz.hijos.get(0).result);
             
            raiz.result = list;
        }
         else if(raiz.lex.equals("LVAL") &&  raiz.hijos.size() == 3){
            ArrayList<Object> list;
            list = (ArrayList<Object>) raiz.hijos.get(0).result;
            
            list.add(raiz.hijos.get(2).result);
            raiz.result = list;
        }else if(raiz.lex.equals("LIST") &&  raiz.hijos.size() == 1){
            raiz.result = raiz.hijos.get(0).result;
        }
        else if(raiz.lex.equals("LIST") &&  raiz.hijos.size() == 2){
           
            raiz.result = "@"+raiz.hijos.get(1).lex;
        }
        else if(raiz.lex.equals("VALOR") &&  raiz.hijos.size() == 1){
            raiz.result = raiz.hijos.get(0).result;
        }else if(raiz.lex.equals("VALOR OP") &&  raiz.hijos.size() == 1){
            raiz.result = raiz.hijos.get(0).result;
        }
        else if(raiz.lex.equals("VALOR FUNC") &&  raiz.hijos.size() == 1){
            raiz.result = raiz.hijos.get(0).result;
        }
        else if (raiz.lex.equals("OPARIT")  &&  raiz.hijos.size() == 6){
            //operaciones aritmeticas
            Double val1 = (Double) raiz.hijos.get(2).result;
            Double val2 = (Double)raiz.hijos.get(4).result;
            Double res;
            if("sum".equalsIgnoreCase(raiz.hijos.get(0).lex)){
                res =  val1 +  val2;
                raiz.result = res;
            } else  if("res".equalsIgnoreCase(raiz.hijos.get(0).lex)){
                res =  val1 -  val2;
                raiz.result = res;
            }else  if("mul".equalsIgnoreCase(raiz.hijos.get(0).lex)){
                res =  val1 *  val2;
                raiz.result = res;
            }else  if("div".equalsIgnoreCase(raiz.hijos.get(0).lex)){
                res =  val1 /  val2;
                raiz.result = res;
            }else  if("mod".equalsIgnoreCase(raiz.hijos.get(0).lex)){
                res =  val1 %  val2;
                raiz.result = res;
            }
         
        }else if(raiz.lex.equals("E") &&  raiz.hijos.size() == 1){
            try{
            Double res = Double.parseDouble(raiz.hijos.get(0).lex);
            raiz.result = res;
            }catch(Exception e){
                if(!raiz.hijos.get(0).lex.startsWith("\"")){
                String val = this.getValor(TS, raiz.hijos.get(0).lex).toString();
                    if(val.equals("Semantic Error")){
                        System.out.println("Error semantico, variable no encontrada");
                    }else{
                        System.out.println("viene un id"+ val);
                        raiz.result = val;
                    }
                }else{
                    raiz.result = raiz.hijos.get(0).lex;
                }
            }
            }else if(raiz.lex.equals("FUNC")){
            
            if(raiz.hijos.get(2).result instanceof ArrayList){
                raiz.result = hacerFuncion((ArrayList<Object>)raiz.hijos.get(2).result, raiz.hijos.get(0).lex);
            }else{
                
                ArrayList<Object> val = (ArrayList<Object>) this.getValor(TS, raiz.hijos.get(2).result.toString());
                raiz.result = hacerFuncion(val, raiz.hijos.get(0).lex);
            }
               
            }
        else if(raiz.lex.equals("COD") &&  raiz.hijos.size() == 1){
            raiz.result = raiz.hijos.get(0).result;
        }else if(raiz.lex.equals("IMP") ){
            
            raiz.result = armarPrint((ArrayList<Object>)raiz.hijos.get(5).result);
        }
        else if(raiz.lex.equals("LC") &&  raiz.hijos.size() == 1){
             raiz.result = raiz.hijos.get(0).result;
            
        }else if(raiz.lex.equals("LC") &&  raiz.hijos.size() == 2){
             raiz.result = raiz.hijos.get(1).result;
            
        }
        else if (raiz.lex.equals("S")){
            
             raiz.result = raiz.hijos.get(1).result;
        }
    }
                
        public String armarPrint(ArrayList<Object> listaObjetos){
            String msj = "";
            boolean primeraIteracion = true;
            for(Object m: listaObjetos){
               if (primeraIteracion) {
                 if(m instanceof String){
                    msj += m.toString().replace("\"", "");
                }else{
                     msj += m;
                 }
                primeraIteracion = false;
            } else {
                  if(m instanceof String){
                    msj += ", " + m.toString().replace("\"", "");
                }else{
                     msj +=  ", " + m;
                 }
            }
            }
            return msj;
        }
        public Object hacerFuncion(ArrayList<Object> listaObjetos, String funcion){
            if(funcion.equalsIgnoreCase("mediana")){
            
                return calcularMediana(listaObjetos);
            }else if(funcion.equalsIgnoreCase("media")){
                return calcularMedia(listaObjetos);
            }else if(funcion.equalsIgnoreCase("moda")){
                return calcularModa(listaObjetos);
            }else if(funcion.equalsIgnoreCase("varianza")){
                return calcularVarianza(listaObjetos);
            }else if(funcion.equalsIgnoreCase("max")){
                return calcularMax(listaObjetos);
            }else if(funcion.equalsIgnoreCase("min")){
                return calcularMin(listaObjetos);
            }
            return null;
        }
        
        public double calcularMediana(ArrayList<Object> lista) {
        if (lista == null || lista.isEmpty()) {
            // Manejar caso de lista vacía o nula
            throw new IllegalArgumentException("La lista no puede ser nula o vacía");
        }

        // Convertir objetos a doubles
        ArrayList<Double> listaDoubles = new ArrayList<>();
        try{
        for (Object objeto : lista) {
           
                listaDoubles.add(Double.parseDouble(objeto.toString()));
           
        }
        }catch(Exception e){
            return 0;
        }
        // Ordenar la lista de doubles
        Collections.sort(listaDoubles);

        int tamaño = listaDoubles.size();

        if (tamaño % 2 == 0) {
            // Si la lista tiene un número par de elementos, calcular la mediana promediando los dos valores del medio
            int indiceMitad1 = tamaño / 2 - 1;
            int indiceMitad2 = tamaño / 2;
            return (listaDoubles.get(indiceMitad1) + listaDoubles.get(indiceMitad2)) / 2.0;
        } else {
            // Si la lista tiene un número impar de elementos, devolver el valor del medio
            int indiceMedio = tamaño / 2;
            return listaDoubles.get(indiceMedio);
        }
    }
        
public double calcularMedia(ArrayList<Object> lista) {
    if (lista == null || lista.isEmpty()) {
        // Manejar caso de lista vacía o nula
        throw new IllegalArgumentException("La lista no puede ser nula o vacía");
    }

    // Convertir objetos a doubles
    ArrayList<Double> listaDoubles = new ArrayList<>();
    try {
        for (Object objeto : lista) {
            listaDoubles.add(Double.parseDouble(objeto.toString()));
        }
    } catch (Exception e) {
        return 0;
    }

    // Calcular la suma de los elementos en la lista
    double suma = 0;
    for (double numero : listaDoubles) {
        suma += numero;
    }

    // Calcular la media
    double media = suma / listaDoubles.size();

    return media;
}

public double calcularVarianza(ArrayList<Object> lista) {
        if (lista == null || lista.isEmpty()) {
            // Manejar caso de lista vacía o nula
            throw new IllegalArgumentException("La lista no puede ser nula o vacía");
        }

       
        // Calcular la media
        double media = calcularMedia(lista);

        // Calcular la suma de los cuadrados de las diferencias entre cada elemento y la media
        double sumaCuadradosDiferencias = 0;
        for (Object valor : lista) {
            sumaCuadradosDiferencias += Math.pow(Double.parseDouble(valor.toString()) - media, 2);
        }

        // Calcular la varianza como la suma de los cuadrados dividida por la cantidad de elementos
        double varianza = sumaCuadradosDiferencias / lista.size();

        return varianza;
    }

public double calcularModa(ArrayList<Object> lista) {
        if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede ser nula o vacía");
        }

        // Convertir objetos a doubles
        ArrayList<Double> listaDoubles = new ArrayList<>();
        try {
            for (Object objeto : lista) {
                listaDoubles.add(Double.parseDouble(objeto.toString()));
            }
        } catch (Exception e) {
            return 0;
        }

        // Contar la frecuencia de cada elemento
        Map<Double, Integer> frecuencias = new HashMap<>();
        for (double numero : listaDoubles) {
            frecuencias.put(numero, frecuencias.getOrDefault(numero, 0) + 1);
        }

        // Encontrar el valor con mayor frecuencia (moda)
        double moda = 0;
        int maxFrecuencia = 0;
        for (Map.Entry<Double, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                moda = entry.getKey();
                maxFrecuencia = entry.getValue();
            }
        }

        return moda;
    }


public double calcularMax(ArrayList<Object> lista) {
        if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede ser nula o vacía");
        }

        // Convertir objetos a doubles
        ArrayList<Double> listaDoubles = new ArrayList<>();
        try {
            for (Object objeto : lista) {
                listaDoubles.add(Double.parseDouble(objeto.toString()));
            }
        } catch (Exception e) {
            return 0;
        }

        double valorMax = Collections.max(listaDoubles); 

        return valorMax;
    }

public double calcularMin(ArrayList<Object> lista) {
        if (lista == null || lista.isEmpty()) {
            throw new IllegalArgumentException("La lista no puede ser nula o vacía");
        }

        // Convertir objetos a doubles
        ArrayList<Double> listaDoubles = new ArrayList<>();
        try {
            for (Object objeto : lista) {
                listaDoubles.add(Double.parseDouble(objeto.toString()));
            }
        } catch (Exception e) {
            return 0;
        }

        double valorMin = Collections.min(listaDoubles); 

        return valorMin;
    }
    
    @Override
    public String toString() {
        // Devuelve una representación significativa del objeto
        return this.lex; // Ajusta según tus necesidades
    }
}
