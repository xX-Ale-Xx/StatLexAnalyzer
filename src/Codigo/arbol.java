/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Javier Avila
 */
public class arbol {

    public ArrayList<String> ListaImagenes;
    public String lex;
    public ArrayList<arbol> hijos;
    public Object result;
    public static String consola = "";

    public arbol(String lex) {
        this.lex = lex;
        this.hijos = new ArrayList();
        this.ListaImagenes = new ArrayList();
    }

    public void addHijo(arbol hijo) {
        this.hijos.add(hijo);
    }

    public void printArbol(arbol raiz) {
        for (arbol hijo : raiz.hijos) {
            printArbol(hijo);
        }
        System.out.println(raiz.lex);
    }

    public Object getValor(ArrayList<nodoSym> TS, String nombre) {

        for (nodoSym num : TS) {
            if (num.getNombre().equals(nombre)) {

                return num.getValor();
            }

        }
        return "Semantic Error";
    }

    public void run(arbol raiz, ArrayList<nodoSym> TS) {
        for (arbol hijo : raiz.hijos) {

            run(hijo, TS);
        }
        if (raiz.lex.equals("DEC") && raiz.hijos.size() == 13) {
            nodoSym sym = new nodoSym(raiz.hijos.get(5).lex, "Variable", raiz.hijos.get(2).lex, "Local", "", String.valueOf(raiz.hijos.get(8).result), raiz.hijos.get(11).lex, raiz.hijos.get(12).lex);
            TS.add(sym);
        } else if (raiz.lex.equals("DEC") && raiz.hijos.size() == 14) {
            nodoSym sym = new nodoSym(raiz.hijos.get(6).lex, "Variable", raiz.hijos.get(3).lex, "Local", "", String.valueOf(raiz.hijos.get(9).result), raiz.hijos.get(12).lex, raiz.hijos.get(13).lex);
            TS.add(sym);
        } else if (raiz.lex.equals("DARR") && raiz.hijos.size() == 17) {

            nodoSym sym = new nodoSym("@" + raiz.hijos.get(7).lex, "Variable", raiz.hijos.get(3).lex, "Local", "", raiz.hijos.get(11).result, raiz.hijos.get(15).lex, raiz.hijos.get(16).lex);
            TS.add(sym);
        } else if (raiz.lex.equals("DARR") && raiz.hijos.size() == 16) {

            nodoSym sym = new nodoSym("@" + raiz.hijos.get(6).lex, "Variable", raiz.hijos.get(2).lex, "Local", "", raiz.hijos.get(10).result, raiz.hijos.get(14).lex, raiz.hijos.get(15).lex);
            TS.add(sym);
        } else if (raiz.lex.equals("LVAL") && raiz.hijos.size() == 1) {
            ArrayList<Object> list = new ArrayList();
            list.add(raiz.hijos.get(0).result);
            raiz.result = list;
        } else if (raiz.lex.equals("LVAL") && raiz.hijos.size() == 3) {
            ArrayList<Object> list;
            list = (ArrayList<Object>) raiz.hijos.get(0).result;

            list.add(raiz.hijos.get(2).result);
            System.out.println("lista 3 hijos" + list);
            raiz.result = list;
        } else if (raiz.lex.equals("LIST") && raiz.hijos.size() == 1) {
            raiz.result = raiz.hijos.get(0).result;
        } else if (raiz.lex.equals("LIST") && raiz.hijos.size() == 2) {

            raiz.result = "@" + raiz.hijos.get(1).lex;
        } else if (raiz.lex.equals("VALOR") && raiz.hijos.size() == 1) {
            raiz.result = raiz.hijos.get(0).result;
        } else if (raiz.lex.equals("VALOR OP") && raiz.hijos.size() == 1) {
            raiz.result = raiz.hijos.get(0).result;
        } else if (raiz.lex.equals("VALOR FUNC") && raiz.hijos.size() == 1) {
            raiz.result = raiz.hijos.get(0).result;
        } else if (raiz.lex.equals("OPARIT") && raiz.hijos.size() == 6) {
            //operaciones aritmeticas
            try {
                System.out.println(" valor ingresado: " + raiz.hijos.get(2).result + " " + raiz.hijos.get(4).result);
                Double val1 = Double.parseDouble(raiz.hijos.get(2).result.toString());
                Double val2 = Double.parseDouble(raiz.hijos.get(4).result.toString());
                Double res;
                if ("sum".equalsIgnoreCase(raiz.hijos.get(0).lex)) {
                    res = val1 + val2;
                    raiz.result = res;
                } else if ("res".equalsIgnoreCase(raiz.hijos.get(0).lex)) {
                    res = val1 - val2;
                    raiz.result = res;
                } else if ("mul".equalsIgnoreCase(raiz.hijos.get(0).lex)) {
                    res = val1 * val2;
                    raiz.result = res;
                } else if ("div".equalsIgnoreCase(raiz.hijos.get(0).lex)) {
                    res = val1 / val2;
                    raiz.result = res;
                } else if ("mod".equalsIgnoreCase(raiz.hijos.get(0).lex)) {
                    res = val1 % val2;
                    raiz.result = res;
                }
            } catch (Exception e) {
                System.out.println("Error no es un entero");
                System.out.println(raiz.hijos.get(2).result);
                System.out.println(raiz.hijos.get(4).result);
                System.out.println("-------------------------");
            }

        } else if (raiz.lex.equals("E") && raiz.hijos.size() == 1) {
            System.out.println("valor: " + raiz.hijos.get(0).lex + "-----");
            try {
                Double res = Double.parseDouble(raiz.hijos.get(0).lex);
                raiz.result = res;
            } catch (Exception e) {
                if (!raiz.hijos.get(0).lex.startsWith("\"")) {
                    String val = this.getValor(TS, raiz.hijos.get(0).lex).toString();
                    if (val.equals("Semantic Error")) {
                        System.out.println("Error semantico, variable no encontrada");
                    } else {
                        System.out.println("viene un id" + val);
                        raiz.result = val;
                    }
                } else {
                    System.out.println(raiz.hijos.get(0).lex);
                    raiz.result = raiz.hijos.get(0).lex;
                }
            }
        } else if (raiz.lex.equals("FUNC")) {

            if (raiz.hijos.get(2).result instanceof ArrayList) {
                raiz.result = hacerFuncion((ArrayList<Object>) raiz.hijos.get(2).result, raiz.hijos.get(0).lex);
            } else {

                if (!this.getValor(TS, raiz.hijos.get(2).result.toString()).equals("Semantic Error")) {
                    System.out.println("---------" + raiz.hijos.get(2).result.toString());
                    ArrayList<Object> val = (ArrayList<Object>) this.getValor(TS, raiz.hijos.get(2).result.toString());
                    raiz.result = hacerFuncion(val, raiz.hijos.get(0).lex);
                } else {
                    raiz.result = 0;
                }
            }

        } else if (raiz.lex.equals("COD") && raiz.hijos.size() == 1) {
            raiz.result = raiz.hijos.get(0).result;
        } else if (raiz.lex.equals("IMP")) {

            consola += armarPrint((ArrayList<Object>) raiz.hijos.get(5).result);
        } else if (raiz.lex.equals("IMPC")) {
            try {
                if (raiz.hijos.get(8).result instanceof ArrayList) {
                    consola += armarColumn((ArrayList<Object>) raiz.hijos.get(8).result, raiz.hijos.get(5).result.toString());
                } else {
                    try {
                        ArrayList<Object> val = (ArrayList<Object>) this.getValor(TS, raiz.hijos.get(8).result.toString());
                        consola += armarColumn(val, raiz.hijos.get(5).result.toString());
                    } catch (Exception e) {
                        System.out.println("Array no encontrado");
                    }

                }
            } catch (Exception e) {
                System.out.println("valor nulo");
            }
        } else if (raiz.lex.equals("DATOS")) {

            if (raiz.hijos.get(5).result instanceof ArrayList) {
                System.out.println("-------ola-----");
                datosGraph d = new datosGraph(raiz.hijos.get(0).lex, raiz.hijos.get(3).lex, raiz.hijos.get(5).result, raiz.hijos.get(8).lex, raiz.hijos.get(9).lex);
                raiz.result = d;
            } else if (!raiz.hijos.get(5).result.toString().startsWith("\"")) {
                try {
                    ArrayList<Object> val = (ArrayList<Object>) this.getValor(TS, raiz.hijos.get(5).result.toString());
                    datosGraph d = new datosGraph(raiz.hijos.get(0).lex, raiz.hijos.get(3).lex, val, raiz.hijos.get(8).lex, raiz.hijos.get(9).lex);
                    raiz.result = d;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                datosGraph d = new datosGraph(raiz.hijos.get(0).lex, raiz.hijos.get(3).lex, raiz.hijos.get(5).result, raiz.hijos.get(8).lex, raiz.hijos.get(9).lex);
                raiz.result = d;
            }

        } else if (raiz.lex.equals("SENTENCES") && raiz.hijos.size() == 1) {
            HashMap<String, Object> datos = new HashMap<>();
            datosGraph d = (datosGraph) raiz.hijos.get(0).result;
            datos.put(d.getNombre(), raiz.hijos.get(0).result);
            raiz.result = datos;
        } else if (raiz.lex.equals("SENTENCES") && raiz.hijos.size() == 2) {
            HashMap<String, Object> datos = (HashMap<String, Object>) raiz.hijos.get(0).result;
            datosGraph d = (datosGraph) raiz.hijos.get(1).result;
            datos.put(d.getNombre(), raiz.hijos.get(1).result);
            raiz.result = datos;
        } else if (raiz.lex.equals("GRAPH")) {
            System.out.println("AQUI VOY A GRAFICAR");
            VerificarDatos((HashMap<String, Object>) raiz.hijos.get(2).result, raiz.hijos.get(0).lex);
        } else if (raiz.lex.equals("TCOLUMN")) {
            if (raiz.hijos.get(0).lex.startsWith("\"")) {
                raiz.result = raiz.hijos.get(0).lex;
            } else {
                String val = this.getValor(TS, raiz.hijos.get(0).lex).toString();
                System.out.println(val);
                if (val.equals("Semantic Error")) {
                    System.out.println("Error semantico, variable no encontrada");
                } else {
                    System.out.println("viene un id" + val);
                    raiz.result = val;
                }
            }

        } else if (raiz.lex.equals("LC") && raiz.hijos.size() == 1) {
            raiz.result = raiz.hijos.get(0).result;

        } else if (raiz.lex.equals("LC") && raiz.hijos.size() == 2) {
            try {

                raiz.result = raiz.hijos.get(0).result.toString() + raiz.hijos.get(1).result.toString();
            } catch (Exception e) {
                raiz.result = raiz.hijos.get(1).result;
            }

        } else if (raiz.lex.equals("S")) {

            raiz.result = raiz.hijos.get(1).result;
        }

    }

    public String armarPrint(ArrayList<Object> listaObjetos) {
        String msj = "";
        boolean primeraIteracion = true;
        for (Object m : listaObjetos) {
            if (primeraIteracion) {
                if (m instanceof String) {
                    msj += m.toString().replace("\"", "");
                } else {
                    msj += m;
                }
                primeraIteracion = false;
            } else {
                if (m instanceof String) {
                    msj += ", " + m.toString().replace("\"", "");
                } else {
                    msj += ", " + m;
                }
            }
        }
        return msj + "\n";
    }

    public String armarColumn(ArrayList<Object> listaObjetos, String titulo) {

        String msj = "---------------------\n";
        msj += "       " + titulo.replace("\"", "") + "\n";
        msj += "---------------------\n";

        for (Object m : listaObjetos) {
            msj += m.toString() + "\n";
        }

        return msj;
    }

    public Object hacerFuncion(ArrayList<Object> listaObjetos, String funcion) {
        if (funcion.equalsIgnoreCase("mediana")) {

            return calcularMediana(listaObjetos);
        } else if (funcion.equalsIgnoreCase("media")) {
            return calcularMedia(listaObjetos);
        } else if (funcion.equalsIgnoreCase("moda")) {
            return calcularModa(listaObjetos);
        } else if (funcion.equalsIgnoreCase("varianza")) {
            return calcularVarianza(listaObjetos);
        } else if (funcion.equalsIgnoreCase("max")) {
            return calcularMax(listaObjetos);
        } else if (funcion.equalsIgnoreCase("min")) {
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
        try {
            for (Object objeto : lista) {

                listaDoubles.add(Double.parseDouble(objeto.toString()));

            }
        } catch (Exception e) {
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
            System.out.println("valooorr" + valor.toString());
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

    public void VerificarDatos(HashMap<String, Object> values, String tipoGrafica) {

        if (tipoGrafica.equalsIgnoreCase("graphPie")) {
            datosGraph d = new datosGraph();
            datosGraph v = new datosGraph();
            datosGraph l = new datosGraph();
            for (String val : values.keySet()) {
                datosGraph p = (datosGraph) values.get(val);
                System.out.println("este valor trae: " + p.getValor());
                if (val.equalsIgnoreCase("titulo")) {
                    d = (datosGraph) values.get(val);
                } else if (val.equalsIgnoreCase("label")) {
                    l = (datosGraph) values.get(val);
                } else if (val.equalsIgnoreCase("values")) {
                    v = (datosGraph) values.get(val);
                }

            }
            try {
                ArrayList<Double> prueba = new ArrayList();
                for (Object o : (ArrayList<Object>) v.getValor()) {
                    prueba.add(Double.parseDouble(o.toString()));
                }

                generatePieChart((ArrayList<String>) l.getValor(), prueba, "C:\\Users\\Javier Avila\\Documents\\NetBeansProjects\\JavaApplication1\\graficas\\" + String.valueOf(d.getValor()).replaceAll("\"", "") + ".png", String.valueOf(d.getValor()));
            } catch (Exception e) {
                System.out.println(e.toString());
                System.out.println("No se pudo realizar la grafica de pie");
            }
        } else if (tipoGrafica.equalsIgnoreCase("graphBar")) {
            datosGraph d = new datosGraph();
            datosGraph v = new datosGraph();
            datosGraph l = new datosGraph();
            datosGraph ex = new datosGraph();
            datosGraph ey = new datosGraph();
            datosGraph err;
            for (String val : values.keySet()) {
                datosGraph p = (datosGraph) values.get(val);
                System.out.println("este valor trae: " + p.getValor());
                if (val.equalsIgnoreCase("titulo")) {
                    d = (datosGraph) values.get(val);
                } else if (val.equalsIgnoreCase("titulox")) {
                    l = (datosGraph) values.get(val);
                } else if (val.equalsIgnoreCase("tituloy")) {
                    v = (datosGraph) values.get(val);
                } else if (val.equalsIgnoreCase("ejex")) {
                    ex = (datosGraph) values.get(val);
                } else if (val.equalsIgnoreCase("ejey")) {
                    ey = (datosGraph) values.get(val);
                } else {
                    err = (datosGraph) values.get(val);
                    error e = new error("llego un " + err.getNombre() + " no esperado", err.getTipo(), err.getF(), err.getC());
                    Listas.setListaErrores(e);
                }

            }
            try {
                ArrayList<Double> prueba = new ArrayList();
                for (Object o : (ArrayList<Object>) ey.getValor()) {
                    prueba.add(Double.parseDouble(o.toString()));
                }
                graphBarChart(String.valueOf(d.getValor()), String.valueOf(v.getValor()), String.valueOf(l.getValor()), (ArrayList<String>) ex.getValor(), prueba,
                        "C:\\Users\\Javier Avila\\Documents\\NetBeansProjects\\JavaApplication1\\graficas\\" + String.valueOf(d.getValor()).replaceAll("\"", "") + ".png");
            } catch (Exception e) {
                System.out.println(e.toString());
                System.out.println("No se pudo realizar la grafica de pie");
            }
        } else if (tipoGrafica.equalsIgnoreCase("graphLine")) {
            datosGraph d = new datosGraph();
            datosGraph v = new datosGraph();
            datosGraph l = new datosGraph();
            datosGraph ex = new datosGraph();
            datosGraph ey = new datosGraph();
            datosGraph c;
            for (String val : values.keySet()) {
                datosGraph p = (datosGraph) values.get(val);
                System.out.println("este valor trae: " + p.getValor());
                if (val.equalsIgnoreCase("titulo")) {
                    d = (datosGraph) values.get(val);
                } else if (val.equalsIgnoreCase("titulox")) {
                    l = (datosGraph) values.get(val);
                } else if (val.equalsIgnoreCase("tituloy")) {
                    v = (datosGraph) values.get(val);
                } else if (val.equalsIgnoreCase("ejex")) {
                    ex = (datosGraph) values.get(val);
                } else if (val.equalsIgnoreCase("ejey")) {
                    ey = (datosGraph) values.get(val);
                } else {
                    c = (datosGraph) values.get(val);
                    error e = new error("llego un " + c.getNombre() + " no esperado", c.getTipo(), c.getF(), c.getC());
                    Listas.setListaErrores(e);
                }

                System.out.println("titulo " + d.getValor());
                System.out.println("titulox " + l.getValor());
                System.out.println("tituloy " + v.getValor());
                System.out.println("ejex " + ex.getValor());
                System.out.println("ejey " + ey.getValor());
            }
            try {
                ArrayList<Double> prueba = new ArrayList();
                for (Object o : (ArrayList<Object>) ey.getValor()) {
                    prueba.add(Double.parseDouble(o.toString()));
                }
                graphLineChart(String.valueOf(d.getValor()), String.valueOf(v.getValor()), String.valueOf(l.getValor()), (ArrayList<String>) ex.getValor(), prueba,
                        "C:\\Users\\Javier Avila\\Documents\\NetBeansProjects\\JavaApplication1\\graficas\\" + String.valueOf(d.getValor()).replaceAll("\"", "") + ".png");
            } catch (Exception e) {
                System.out.println(e.toString());
                System.out.println("No se pudo realizar la grafica de pie");
                e.printStackTrace();
            }
        } else if (tipoGrafica.equalsIgnoreCase("histogram")) {
            datosGraph d = new datosGraph();
            datosGraph v = new datosGraph();
            datosGraph err;
            for (String val : values.keySet()) {
                datosGraph p = (datosGraph) values.get(val);
                System.out.println("este valor trae: " + p.getValor());
                if (val.equalsIgnoreCase("titulo")) {
                    d = (datosGraph) values.get(val);
                } else if (val.equalsIgnoreCase("values")) {
                    v = (datosGraph) values.get(val);
                } else {
                    err = (datosGraph) values.get(val);
                    error e = new error("llego un " + err.getNombre() + " no esperado", err.getTipo(), err.getF(), err.getC());
                    Listas.setListaErrores(e);
                }

            }
            try {
                ArrayList<Double> prueba = new ArrayList();
                for (Object o : (ArrayList<Object>) v.getValor()) {
                    prueba.add(Double.parseDouble(o.toString()));
                }
                consola += calcularFrecuencias(prueba, String.valueOf(d.getValor()));
            } catch (Exception e) {
                System.out.println(e.toString());
                System.out.println("No se pudo realizar la grafica de pie");
            }
        }
    }

    public void generatePieChart(ArrayList<String> labels, ArrayList<Double> values, String outputPath, String chartTitle) {
        // Crear un conjunto de datos de tipo pie
        DefaultPieDataset dataset = new DefaultPieDataset();

        // Agregar los datos al conjunto de datos
        for (int i = 0; i < labels.size(); i++) {
            dataset.setValue(labels.get(i), values.get(i));
        }

        // Crear la gráfica de pastel
        JFreeChart chart = ChartFactory.createPieChart(
                chartTitle, // Título de la gráfica
                dataset, // Datos
                true, // Mostrar leyenda
                true,
                false
        );

        // Personalizar la apariencia de la gráfica
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.black);

        // Personalizar la apariencia de la leyenda
        chart.getLegend().setFrame(BlockBorder.NONE);
        chart.getLegend().setBackgroundPaint(Color.white);
        chart.getLegend().setItemPaint(Color.black);

        // Configurar el estilo de la etiqueta
        chart.getPlot().setOutlineVisible(false);
        chart.getPlot().setBackgroundPaint(Color.white);
        chart.getPlot().setForegroundAlpha(0.5f);

        try {
            ListaImagenes.add(outputPath);
            // Guardar la gráfica como una imagen
            ChartUtilities.saveChartAsPNG(new File(outputPath), chart, 600, 400);
        } catch (IOException e) {
            System.err.println("Error al guardar la gráfica como imagen: " + e.getMessage());
            System.out.println(e.getCause());
        }
    }

    public void graphBarChart(String title, String yAxisTitle, String xAxisTitle,
            ArrayList<String> categories, ArrayList<Double> values, String outputPath) {
        // Crear el conjunto de datos
        CategoryDataset dataset = createDataset(categories, values);

        // Crear el gráfico de barras
        JFreeChart chart = ChartFactory.createBarChart(
                title, // Título del gráfico
                xAxisTitle, // Título del eje X
                yAxisTitle, // Título del eje Y
                dataset, // Conjunto de datos
                PlotOrientation.VERTICAL,
                true, // Incluir leyenda
                true,
                false
        );

        // Personalizar la apariencia del gráfico
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        // Puedes agregar personalizaciones adicionales aquí si es necesario

        // Guardar el gráfico como imagen en un archivo PNG
        try {
            ListaImagenes.add(outputPath);
            ChartUtilities.saveChartAsPNG(new File(outputPath), chart, 800, 600);
            System.out.println("Gráfico de barras guardado en: " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private CategoryDataset createDataset2(ArrayList<String> categories, ArrayList<Double> values) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Asegúrate de que las listas tengan el mismo tamaño
        if (categories.size() != values.size()) {
            throw new IllegalArgumentException("Las listas de categorías y valores deben tener el mismo tamaño");
        }
        System.out.println("ESTE ES EL DATA SET-----------------------------");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(values.get(i));
        }

        // Agrega los datos al conjunto de datos
        for (int i = 0; i < categories.size(); i++) {
            String category = String.valueOf(categories.get(i));
            System.out.println(values.get(i) instanceof Double);

            Double value = (Double) values.get(i);

            // Agrega la categoría y el valor al conjunto de datos
            dataset.addValue(value, "series", category);
        }

        return dataset;
    }

    private CategoryDataset createDataset(ArrayList<String> categories, ArrayList<Double> values) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int i = 0; i < categories.size(); i++) {
            dataset.addValue(values.get(i), "Series 1", categories.get(i));
        }

        return dataset;
    }

    public void graphLineChart(String title, String yAxisTitle, String xAxisTitle,
            ArrayList<String> categories, ArrayList<Double> values, String outputPath) {
        // Crear el conjunto de datos
        System.out.println("Llegue------------------------------------------------------------------------------------------");
        CategoryDataset dataset = createDataset2(categories, values);

        // Crear el gráfico de líneas
        JFreeChart chart = ChartFactory.createLineChart(
                title, // Título del gráfico
                xAxisTitle, // Título del eje X
                yAxisTitle, // Título del eje Y
                dataset, // Conjunto de datos
                PlotOrientation.VERTICAL,
                true, // Incluir leyenda
                true,
                false
        );

        // Personalizar la apariencia del gráfico
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        // Puedes agregar personalizaciones adicionales aquí si es necesario

        // Guardar el gráfico como imagen en un archivo PNG
        try {
            ListaImagenes.add(outputPath);
            ChartUtilities.saveChartAsPNG(new File(outputPath), chart, 800, 600);
            System.out.println("Gráfico de líneas guardado en: " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String calcularFrecuencias(ArrayList<Double> lista, String titulo) {
        String msj = "";
        ArrayList<Double> ejey = new ArrayList();
        ArrayList<String> ejex = new ArrayList();
        Map<Double, Double> frecuencias = new HashMap<>();
        Double n = (double) lista.size();
        Double frecuenciaAcumulada = 0.0;

        // Calcular la frecuencia de cada valor
        for (Double valor : lista) {
            frecuencias.put(valor, frecuencias.getOrDefault(valor, 0.0) + 1);

        }

        // Mostrar los resultados
        msj += "--------------------------------------\n";
        msj += "Valor\tFb\tFa\tFr\n";
        msj += "--------------------------------------\n";

        for (Map.Entry<Double, Double> entry : frecuencias.entrySet()) {
            Double valor = entry.getKey();
            Double frecuencia = entry.getValue();
            ejex.add(String.valueOf(valor));
            frecuenciaAcumulada += frecuencia;
            ejey.add(frecuencia);
            double frecuenciaRelativa = frecuencia / n;
            String format = "%.2f\t%.2f\t%.2f\t%.2f\n";
            msj += String.format(format, valor, frecuencia, frecuenciaAcumulada, frecuenciaRelativa);
        }
        String form = "%.2f";
        msj += "--------------------------------------\n";
        msj += "Total\t" + String.format(form, frecuenciaAcumulada) + "\t" + String.format(form, frecuenciaAcumulada) + "\t 100% \n";
        msj += "--------------------------------------\n";
        graphBarChart(titulo, "", "", ejex, ejey,
                "C:\\Users\\Javier Avila\\Documents\\NetBeansProjects\\JavaApplication1\\graficas\\" + titulo.replaceAll("\"", "") + ".png");
        return msj;
    }

    @Override
    public String toString() {
        // Devuelve una representación significativa del objeto
        return this.lex; // Ajusta según tus necesidades
    }
}
