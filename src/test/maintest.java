/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Codigo.Lexer;
import Codigo.Listas;
import Codigo.Parser;
import Codigo.arbol;
import Codigo.nodoSym;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class maintest {
    
    public static void main(String args[]){
                try{
                    try{
                        String ruta = "./src/Codigo/";
                        String[] opJflex = {ruta+"Lexico.jflex","-d",ruta};
                        JFlex.Main.generate(opJflex);
                        String[] opCup = {"-destdir",ruta,"-parser","Parser",ruta+"Parser.cup"};
                        java_cup.Main.main(opCup);
                    } catch (Exception e){
                    }
                    
                    
                    String entrada = ""
                            + "PROGRAM"
                            +" "
                            +"console :: print = \"hola\" end;"
                            +" "
                            +"console :: print = \"hola\" end;"
                            +" "
                            +"<! Estadísticas de Ingeniería en Guatemala \n hola !>\n"
                            + " "
                            + "var : double :: b <- sum(1,2) end;"
                            + " <!holaaa   jaja   !>\n "
                            +"var : char[] :: c <- \"hola\" end;"
                            +" "
                            + "var : char[] :: k  <- \"hola\" end;"
                            +" "
                            +"arr : double :: @array <- [1, 3, sum(2,1)] end;"
                            +" "
                            +"arr : double :: @array2 <- [Media(@array),MODA(@array)] end;"
                            +" var: double :: m <- MEDIANA([1, 2, b,3]) end;"
                            +" "
                            +" var: double :: e <- Moda(@array) end;"
                            +" "
                            +" var: double :: v <- varianza([1, 2, b,3]) end;"
                            +" "
                              +" "
                            + "var : char[] :: o  <- \"hola\" end;"
                            +" "
                            + "var : char[] :: p  <- \"hola\" end;"
                            +" "
                            +" console :: print = p end; "
                            +""
                             +"console :: print = 2,3,4,1,sum(2,1), moda([1,2,2]), b,\"hola\" end;"
                            +" "
                            +" var: double :: med <- DIV( SUM(Max(@array), Min(@array) ), 2) end;"
                            +" "
                            +"console :: print = 2,3,4,1,sum(2,1), moda([1,2,2]), b,\"hola\" end;"
                            +" "
                            +"console :: print = 2,3,4,1,sum(2,1), moda([1,2,2]), b,\"hola\" end;"
                            +" "
                            +"console :: print = \"hola\" end;"
                            +" "
                            +"console :: column = \"prueba\" -> [2,3,4,1,sum(2,1), moda([1,2,2]), b,\"hola\"] end;"
                            +" "
                            +"  "
                            +"console :: column = \"prueba\" -> @array2 end;"
                            +" "
                            +" graphPie(\n" +
              "titulo::char[] = \"Titulo inicial\" end;\n" +
"label::char[] = [\"dato incorrecto\", \"dato2\" ] end;\n" +
"values::double = [20, 70] end;\n" +
"titulo::char[] = \"Titulo que se debe mostrar\" end;\n" +
"label::char[] = [\"dato correcto\", \"dato2\" ] end;\n" +
"EXEC graphPie end;\n" +
") end; "
                            +" "
                            +"graphBar(\n" +
"titulo::char[] = \"Estudiantes\" end;\n" +
"ejeX::char[] = [\"1 Parcial\", \"2 parcial\", \"Final\"] end;\n" +
"ejeY::double = [50, 30, 70] end;\n" +
"tituloX::char[] = \"Actividades\" end;\n" +
"tituloY::char[] = \"Notas\" end;\n" +
"EXEC graphBar end;\n" +
") end;"
                            +" "
                            +"graphLine(\n" +
"titulo::char[] = \"Gráfica de Línea\" end;\n" +
"ejeX::char[] = [\"1 Parcial\", \"2 parcial\", \"Final\"] end;\n" +
"ejeY::double = [50, 30, 70] end;\n" +
"tituloX::char[] = \"Actividades\" end;\n" +
"tituloY::char[] = \"Notas\" end;\n" +
"EXEC graphLine end;\n" +
") end;"
                            +" "
                            +" Histogram(\n" +
"titulo::char[] = \"Analisis de Arreglo\" end;\n" +
"values::char[] = [2,2,2,5,5,7,8] end;\n" +
"EXEC Histogram end;\n" +
") end;"
                            +" "
                            + "END PROGRAM";
                    
                    ArrayList<nodoSym> TS = new ArrayList();
                    Lexer lex = new Lexer(new StringReader(entrada));
                    Parser sintax = new Parser(lex);
                    arbol raiz = (arbol) sintax.parse().value;
                    raiz.consola = "";
                    raiz.run(raiz, TS);
                    System.out.println("TABLA ---------");
                    for(nodoSym n : TS){
                        System.out.println(n.getNombre()+ " valor: "+ n.getValor());
                    }
                    System.out.println("------EJECUCION------");
                    System.out.println(raiz.consola);
                    
                    Listas.generarTablaHTMLErrores();
                } catch (Exception ex){
            Logger.getLogger(maintest.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    

}
