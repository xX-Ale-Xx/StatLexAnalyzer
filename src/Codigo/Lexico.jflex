// ------------  Paquete e importaciones ------------
package Codigo; 
import java_cup.runtime.Symbol;
%%	
//-------> Directivas (No tocar)

%public 
%class Lexer
%cup
%char
%column
%line
%unicode
%ignorecase

%{ 
%} 

// ------> Expresiones Regulares 

entero = [0-9]+
decimal = {entero}\.{entero}
id = [a-zA-Z][a-zA-Z]*
comentario = !.* "\n"
comentariomultilinea = <!.*!>

%%
// ------------  Reglas Lexicas -------------------

{entero}  {return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }
{decimal} {return new Symbol(sym.DECIMAL,yyline,yycolumn, yytext());}

"program" {return new Symbol(sym.PROGRAM,yyline,yycolumn, yytext());}
"end" {return new Symbol(sym.END,yyline,yycolumn, yytext());}
"sum" {return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"res"   {return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"mul"  {return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"div"   {return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"mod"  {return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"var"  {return new Symbol(sym.VAR,yyline,yycolumn, yytext());}
"double" {return new Symbol(sym.TIPO,yyline,yycolumn, yytext());}


"("       {return new Symbol(sym.PARIZ,yyline,yycolumn, yytext());}
")"       {return new Symbol(sym.PARDE,yyline,yycolumn, yytext());}
","       {return new Symbol(sym.COMA,yyline,yycolumn, yytext());}
";"       {return new Symbol(sym.PYC,yyline,yycolumn, yytext());}
":"       {return new Symbol(sym.DOSP,yyline,yycolumn, yytext());}
"<"      {return new Symbol(sym.MENOR,yyline,yycolumn, yytext());}
"-"       {return new Symbol(sym.GUION,yyline,yycolumn, yytext());}

{id} {return new Symbol(sym.ID,yyline,yycolumn, yytext());}

//------> Ingorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}
{comentario} {/* Espacios en blanco se ignoran */}
{comentariomultilinea} {/* Espacios en blanco se ignoran */}
//------> Errores Léxicos 
.           	{ System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); }

