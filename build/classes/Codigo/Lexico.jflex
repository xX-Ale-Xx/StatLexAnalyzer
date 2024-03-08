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
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.ENTERO, yycolumn, yyline, yytext()); }
{decimal} {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.DECIMAL,yyline,yycolumn, yytext());}
{cadena} {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.CADENA,yyline,yycolumn, yytext());}

"program" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.PROGRAM,yyline,yycolumn, yytext());}
"end" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.END,yyline,yycolumn, yytext());}
"sum" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"res"   {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"mul"  {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"div"   {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"mod"  {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.OPERACION,yyline,yycolumn, yytext());}
"var"  {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.VAR,yyline,yycolumn, yytext());}
"double" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.TIPO,yyline,yycolumn, yytext());}
"char[]" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.TIPO,yyline,yycolumn, yytext());}
"arr" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.ARR,yyline,yycolumn, yytext());}


"media"   {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.ESTADISTICO,yyline,yycolumn, yytext());}
"mediana" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.ESTADISTICO,yyline,yycolumn, yytext());}
"moda"  {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.ESTADISTICO,yyline,yycolumn, yytext());}
"varianza" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.ESTADISTICO,yyline,yycolumn, yytext());}
"max" {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.ESTADISTICO,yyline,yycolumn, yytext());}
"min"  {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.ESTADISTICO,yyline,yycolumn, yytext());}

"console"   {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.CONSOLE,yyline,yycolumn, yytext());}
"print"    {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.PRINT,yyline,yycolumn, yytext());}

"column"    {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.COLUMN,yyline,yycolumn, yytext());
}

"="      {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.IGUAL,yyline,yycolumn, yytext());  
}
"@"     {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.ARROBA,yyline,yycolumn, yytext());}
"["        {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.LLDER,yyline,yycolumn, yytext());}
"]"         {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.LLIZ,yyline,yycolumn, yytext());}
"("       {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.PARIZ,yyline,yycolumn, yytext());}
")"       {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.PARDE,yyline,yycolumn, yytext());}
","       {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.COMA,yyline,yycolumn, yytext());}
";"       {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.PYC,yyline,yycolumn, yytext());}
":"       {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.DOSP,yyline,yycolumn, yytext());}
"<"      {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.MENOR,yyline,yycolumn, yytext());}
"-"       {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.GUION,yyline,yycolumn, yytext());}
">"      {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.MAYOR,yyline,yycolumn, yytext());}

{id} {
Token t = new Token(yytext(),String.valueOf(yyline), String.valueOf(yycolumn) );
Listas.setListaTokens(t);
return new Symbol(sym.ID,yyline,yycolumn, yytext());}

//------> Ingorados 
[ \t\r\n\f]     {/* Espacios en blanco se ignoran */}

//------> Errores Léxicos 
.           	{ 
error e = new error(yytext(), "Lexico", String.valueOf(yyline), String.valueOf(yycolumn));
Listas.setListaErrores(e);
System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn); }

