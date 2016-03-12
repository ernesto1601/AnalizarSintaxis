package analizadorsintactico;
import static  analizadorsintactico.Token.*;
%%
%class Lexer
%type Token
L=[a-z]
A=[A-Z]
D=[0-9]
white= [\n\t]
%{
    public String lexeme;
%}
%%
<YYINITIAL> void {return ninguno;}
<YYINITIAL> main {return principal;}
<YYINITIAL> static {return estatico;}
<YYINITIAL> public {return publico;}
<YYINITIAL> private {return privado;}
<YYINITIAL> class {return clase;}
<YYINITIAL> String {return cadena_id;}
<YYINITIAL> int {return entero_id;}
<YYINITIAL> long {return largo_id;}
<YYINITIAL> double {return doble_id;}
<YYINITIAL> function {return funcion;}


{white} {/*Ignore*/}
" " {return espacio;}
[$]({L}|{D}|{A}|" ")*[$] {lexeme=yytext(); return cadena;}
"=" {return igual;}
({L}|{A}|_)({L}|{D}|{A}|_)* {lexeme=yytext(); return Identificador;}
[-+]?{D}+ {lexeme=yytext(); return Entero;}
"{" {return LLA;}
"}" {return LLC;}
"(" {return PA;}
")" {return PC;}
";" {return punt_coma;}
. {return ERROR;}
