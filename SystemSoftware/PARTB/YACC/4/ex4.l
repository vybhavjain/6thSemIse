%{
#include<stdio.h>
#include"ex4.tab.h"
%}
%%
"a"	{return A;}
"b"	{return B;}
"\n" {printf("\nValid Expression");exit(0);}
.	{return yytext[0];}
%%
int yywrap(){
    return 1;
}
