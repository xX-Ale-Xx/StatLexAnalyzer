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
id = [a-zA-Z][a-zA-Z0-9]*
cadena = [\"][^\n\"]*[\"]
comentario = "!"[^\n\"]*
comentariomultilinea = "<!"~"!>"

%%
// ------------  Reglas Lexicas -------------------
{comentario} {/* Espacios en blanco se ignoran */}
{comentariomultilinea} {/* Espacios en blanco se ignoran */}
{entero}  {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "Integer" );
Listas.setListaTokens(t);
return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }
{decimal} {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) , "Double");
Listas.setListaTokens(t);
return new Symbol(sym.DECIMAL,yyline,yycolumn, yytext());}
{cadena} {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "cadena" );
Listas.setListaTokens(t);
return new Symbol(sym.CADENA,yyline,yycolumn, yytext());}

"program" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) , "palabra reservada program");
Listas.setListaTokens(t);
return new Symbol(sym.PROGRAM,yyline,yycolumn, yytext());}
"end" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) , "palabra reservada end");
Listas.setListaTokens(t);
return new Symbol(sym.END,yyline,yycolumn, yytext());}
"sum" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada sum" );
Listas.setListaTokens(t);
return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"res"   {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada res" );
Listas.setListaTokens(t);
return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"mul"  {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada mul" );
Listas.setListaTokens(t);
return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"div"   {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) , "palabra reservada div");
Listas.setListaTokens(t);
return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"mod"  {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada mod");
Listas.setListaTokens(t);
return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"var"  {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada var" );
Listas.setListaTokens(t);
return new Symbol(sym.VAR,yyline,yycolumn, yytext());}
"double" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada double" );
Listas.setListaTokens(t);
return new Symbol(sym.TIPO,yyline,yycolumn, yytext());}
"char[]" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) , "palabra reservada char[]");
Listas.setListaTokens(t);
return new Symbol(sym.TIPO,yyline,yycolumn, yytext());}
"arr" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) , "palabra reservada arr");
Listas.setListaTokens(t);
return new Symbol(sym.ARR,yyline,yycolumn, yytext());}


"media"   {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada media" );
Listas.setListaTokens(t);
return new Symbol(sym.ESTADISTICO,yyline,yycolumn, yytext());}
"mediana" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada mediana");
Listas.setListaTokens(t);
return new Symbol(sym.ESTADISTICO,yyline,yycolumn, yytext());}
"moda"  {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) , "palabra reservada moda");
Listas.setListaTokens(t);
return new Symbol(sym.ESTADISTICO,yyline,yycolumn, yytext());}
"varianza" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada varianza" );
Listas.setListaTokens(t);
return new Symbol(sym.ESTADISTICO,yyline,yycolumn, yytext());}
"max" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) , "palabra reservada max");
Listas.setListaTokens(t);
return new Symbol(sym.ESTADISTICO,yyline,yycolumn, yytext());}
"min"  {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada min" );
Listas.setListaTokens(t);
return new Symbol(sym.ESTADISTICO,yyline,yycolumn, yytext());}

"console"   {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada console" );
Listas.setListaTokens(t);
return new Symbol(sym.CONSOLE,yyline,yycolumn, yytext());}
"print"    {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada print" );
Listas.setListaTokens(t);
return new Symbol(sym.PRINT,yyline,yycolumn, yytext());}

"column"    {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) , "palabra reservada column");
Listas.setListaTokens(t);
return new Symbol(sym.COLUMN,yyline,yycolumn, yytext());
}


"graphPie" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada graphPie" );
Listas.setListaTokens(t);
return new Symbol(sym.TIPOGRAPH,yyline,yycolumn, yytext());
}
"graphBar" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada graphBar" );
Listas.setListaTokens(t);
return new Symbol(sym.TIPOGRAPH,yyline,yycolumn, yytext());
}
"graphLine" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada graphLine" );
Listas.setListaTokens(t);
return new Symbol(sym.TIPOGRAPH,yyline,yycolumn, yytext());
}
"histogram" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada histogram" );
Listas.setListaTokens(t);
return new Symbol(sym.TIPOGRAPH,yyline,yycolumn, yytext());
}
"EXEC" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) , "palabra reservada EXEC");
Listas.setListaTokens(t);
return new Symbol(sym.EXEC,yyline,yycolumn, yytext());
}

"titulo"  {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn),"palabra reservada titulo" );
Listas.setListaTokens(t);
return new Symbol(sym.TITULO,yyline,yycolumn, yytext());
}
"label" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada label" );
Listas.setListaTokens(t);
return new Symbol(sym.LABEL,yyline,yycolumn, yytext());
}
"values" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada values" );
Listas.setListaTokens(t);
return new Symbol(sym.VALUES,yyline,yycolumn, yytext());
}
"titulox" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada tituloX" );
Listas.setListaTokens(t);
return new Symbol(sym.TITULO,yyline,yycolumn, yytext());}
"tituloy" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada tituloY" );
Listas.setListaTokens(t);
return new Symbol(sym.TITULO,yyline,yycolumn, yytext());}
"ejex" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada ejeX" );
Listas.setListaTokens(t);
return new Symbol(sym.EJE,yyline,yycolumn, yytext());}
"ejey" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "palabra reservada ejeY" );
Listas.setListaTokens(t);
return new Symbol(sym.EJE,yyline,yycolumn, yytext());}


"="      {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "Igual" );
Listas.setListaTokens(t);
return new Symbol(sym.IGUAL,yyline,yycolumn, yytext());  
}
"@"     {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "Arroba" );
Listas.setListaTokens(t);
return new Symbol(sym.ARROBA,yyline,yycolumn, yytext());}
"["        {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "Llave abre" );
Listas.setListaTokens(t);
return new Symbol(sym.LLDER,yyline,yycolumn, yytext());}
"]"         {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "Llave cierra" );
Listas.setListaTokens(t);
return new Symbol(sym.LLIZ,yyline,yycolumn, yytext());}
"("       {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "Parentesis abre" );
Listas.setListaTokens(t);
return new Symbol(sym.PARIZ,yyline,yycolumn, yytext());}
")"       {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "parentesis cierra" );
Listas.setListaTokens(t);
return new Symbol(sym.PARDE,yyline,yycolumn, yytext());}
","       {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "coma" );
Listas.setListaTokens(t);
return new Symbol(sym.COMA,yyline,yycolumn, yytext());}
";"       {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn),"punto y coma" );
Listas.setListaTokens(t);
return new Symbol(sym.PYC,yyline,yycolumn, yytext());}
":"       {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn),"dos puntos" );
Listas.setListaTokens(t);
return new Symbol(sym.DOSP,yyline,yycolumn, yytext());}
"<"      {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "<" );
Listas.setListaTokens(t);
return new Symbol(sym.MENOR,yyline,yycolumn, yytext());}
"-"       {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "guion" );
Listas.setListaTokens(t);
return new Symbol(sym.GUION,yyline,yycolumn, yytext());}
">"      {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), ">" );
Listas.setListaTokens(t);
return new Symbol(sym.MAYOR,yyline,yycolumn, yytext());}

{id} {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn), "id" );
Listas.setListaTokens(t);
return new Symbol(sym.ID,yyline,yycolumn, yytext());}

//------> Ingorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
.           	{ 
error e = new error("El caracter "+yytext()+" no pertenece al lenguaje", "Lexico", String.valueOf(yyline), String.valueOf(yycolumn));
Listas.setListaErrores(e);
System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); }

