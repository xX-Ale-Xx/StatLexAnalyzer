/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import Codigo.Lexer;
import Codigo.Parser;
import Codigo.arbol;
import Codigo.nodoSym;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
/**
 *
 * @author Javier Avila
 */
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
                            + " "
                            + "var : double :: b <- sum(1,2) end;"
                            + " <!holaaa      !>\n "
                            +"var : char[] :: c <- \"hola\" end;"
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
                            +" var: double :: med <- DIV( SUM(Max(@array), Min(@array) ), 2) end;"
                            +" "
                            +"console :: print = 2,3,4,1,sum(2,1), moda([1,2,2]), b,\"hola\" end;"
                            +" "
                            + "END PROGRAM;";
                    
                    ArrayList<nodoSym> TS = new ArrayList();
                    Lexer lex = new Lexer(new StringReader(entrada));
                    Parser sintax = new Parser(lex);
                    arbol raiz = (arbol) sintax.parse().value;
                
                    raiz.run(raiz, TS);
                    for(nodoSym n : TS){
                        System.out.println(n.getNombre()+ " valor: "+ n.getValor());
                    }
                    System.out.println("------EJECUCION------");
                    System.out.println(raiz.result);
                } catch (Exception ex){
            Logger.getLogger(maintest.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    

}
