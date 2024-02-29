// ------------  Paquete e importaciones ------------
package Codigo; 

import java_cup.runtime.*;

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
caracter = [a-zA-Z]+


%%
// ------------  Reglas Lexicas -------------------

{entero}  { return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }
{decimal} {return new Symbol(sym.DECIMAL,yyline,yycolumn, yytext());}
{caracter} {return new Symbol(sym.CARACTER,yyline,yycolumn, yytext());}

"program" {return new Symbol(sym.PROGRAM,yyline,yycolumn, yytext());}
"end" {return new Symbol(sym.END,yyline,yycolumn, yytext());}
"sum" {return new Symbol(sym.SUMAR,yyline,yycolumn, yytext());}
"res"   {return new Symbol(sym.RESTAR,yyline,yycolumn, yytext());}
"mul"  {return new Symbol(sym.MULTI,yyline,yycolumn, yytext());}
"div"   {return new Symbol(sym.DIVIDIR,yyline,yycolumn, yytext());}
"arr"   {return new Symbol(sym.ARR,yyline,yycolumn, yytext());}
"var"  {return new Symbol(sym.VAR,yyline,yycolumn, yytext());}
"mod"  {return new Symbol(sym.MOD,yyline,yycolumn, yytext());}
"double" {return new Symbol(sym.DOUB,yyline,yycolumn, yytext());}
"char" {return new Symbol(sym.CHAR,yyline,yycolumn, yytext());}


"media"   {return new Symbol(sym.MEDIA,yyline,yycolumn, yytext());}
"mediana" {return new Symbol(sym.MEDIANA,yyline,yycolumn, yytext());}
"moda"  {return new Symbol(sym.MODA,yyline,yycolumn, yytext());}
"varianza" {return new Symbol(sym.VARIANZA,yyline,yycolumn, yytext());}
"max" {return new Symbol(sym.MAXIMO,yyline,yycolumn, yytext());}
"min"  {return new Symbol(sym.MINIMO,yyline,yycolumn, yytext());}

"console" {return new Symbol(sym.CONSOL,yyline,yycolumn, yytext());}
"print" {return new Symbol(sym.PRINT,yyline,yycolumn, yytext());}
"column" {return new Symbol(sym.COLUM,yyline,yycolumn, yytext());}

"="       {return new Symbol(sym.IGUAL,yyline,yycolumn, yytext());}
"@"     {return new Symbol(sym.ARROBA,yyline,yycolumn, yytext());}
"["       {return new Symbol(sym.CORIZ,yyline,yycolumn, yytext());}
"]"        {return new Symbol(sym.CORDE,yyline,yycolumn, yytext());}
"("       {return new Symbol(sym.PARIZ,yyline,yycolumn, yytext());}
")"       {return new Symbol(sym.PARDE,yyline,yycolumn, yytext());}
","       {return new Symbol(sym.COMA,yyline,yycolumn, yytext());}
"!"       {return new Symbol(sym.COMENT,yyline,yycolumn, yytext());}
"<"      {return new Symbol(sym.MENOR,yyline,yycolumn, yytext());}
">"      {return new Symbol(sym.MAYOR,yyline,yycolumn, yytext());}
":"       {return new Symbol(sym.DOSP,yyline,yycolumn, yytext());}
"-"       {return new Symbol(sym.GUION,yyline,yycolumn, yytext());}
";"       {return new Symbol(sym.PYC,yyline,yycolumn, yytext());}
"\""     {return new Symbol(sym.COMILLA,yyline,yycolumn, yytext());}

//------> Ingorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
.           	{ System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); }

