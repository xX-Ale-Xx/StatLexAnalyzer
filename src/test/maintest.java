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
                            + " "
                            + "var : double :: b <- sum(1,2) end;"
                            + "  "
                            +"var : double :: c <- sum(1,2) end;"
                            +" "
                             +"var : double :: a <- sum(b,2)end;"
                            + "END PROGRAM;";
                    ArrayList<nodoSym> TS = new ArrayList();
                    Lexer lex = new Lexer(new StringReader(entrada));
                    Parser sintax = new Parser(lex);
                    arbol raiz = (arbol) sintax.parse().value;
                
                    raiz.run(raiz, TS);
                
                    System.out.println(raiz.result);
                } catch (Exception ex){
            Logger.getLogger(maintest.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    

}
