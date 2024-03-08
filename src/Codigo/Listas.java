/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Listas {
    private static ArrayList<Token> ListaTokens = new ArrayList();
    private static ArrayList<error> ListaErrores = new ArrayList();
    
    public Listas(){
        
    }

    public static void setListaTokens(Token t) {
        Listas.ListaTokens.add(t);
    }

    public static void setListaErrores(error e) {
        Listas.ListaErrores.add(e);
    }
    
    public static void generarTablaHTMLTokens() {
        
        StringBuilder tabla = new StringBuilder();
       tabla.append("<h2>").append("Tokens").append("</h2>\n");
        // Inicio de la tabla
        tabla.append("<table border=\"1\">\n");

        // Encabezados de la tabla
        tabla.append("<tr>");
        tabla.append("<th>Token</th>");
        tabla.append("<th>Linea</th>");
        tabla.append("<th>Columna</th>");
        tabla.append("</tr>\n");

        // Agregar datos a la tabla
        for (Token t : ListaTokens) {
            tabla.append("<tr>");
            
            tabla.append("<td>").append(t.getLexema()).append("</td>");
            tabla.append("<td>").append(t.getFila()).append("</td>");
            tabla.append("<td>").append(t.getColumna()).append("</td>");
            
            tabla.append("</tr>\n");
        }

        // Fin de la tabla
        tabla.append("</table>");

         escribirArchivoHTML("C:\\Users\\Javier Avila\\Documents\\NetBeansProjects\\JavaApplication1\\Reportes\\ Tokens.html", tabla.toString());
    }
    
    public static void generarTablaHTMLErrores() {
        
        StringBuilder tabla = new StringBuilder();
       tabla.append("<h2>").append("Errores").append("</h2>\n");
        // Inicio de la tabla
        tabla.append("<table border=\"1\">\n");

        // Encabezados de la tabla
        tabla.append("<tr>");
        tabla.append("<th>Error</th>");
        tabla.append("<th>Tipo</th>");
        tabla.append("<th>Linea</th>");
        tabla.append("<th>Columna</th>");
        tabla.append("</tr>\n");

        // Agregar datos a la tabla
        for (error e : ListaErrores) {
            tabla.append("<tr>");
            
            tabla.append("<td>").append(e.getLexema()).append("</td>");
            tabla.append("<td>").append(e.getTipo()).append("</td>");
            tabla.append("<td>").append(e.getFila()).append("</td>");
            tabla.append("<td>").append(e.getColumna()).append("</td>");
            
            tabla.append("</tr>\n");
        }

        // Fin de la tabla
        tabla.append("</table>");

         escribirArchivoHTML("C:\\Users\\Javier Avila\\Documents\\NetBeansProjects\\JavaApplication1\\Reportes\\Errores.html", tabla.toString());
    }
    
        public static void escribirArchivoHTML(String rutaArchivo, String contenidoHTML) {
        try {
            FileWriter fileWriter = new FileWriter(rutaArchivo);

            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.println(contenidoHTML);

            printWriter.close();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
