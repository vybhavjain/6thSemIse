%{
#include "3.tab.h"
%}
%%
[0-9]+ {yylval=atoi(yytext); return NUMBER;}
\n {return NL;}
. {return yytext[0];}
%%
int yywrap(){
    return 1;
}
