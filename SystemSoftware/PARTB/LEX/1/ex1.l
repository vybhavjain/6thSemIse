%{
#include<stdio.h>
int cchar = 0,cwords = 0,cline = 0,cspaces = 0;
%}

%%
[a-zA-Z]+ {cwords++;cchar+=yyleng;}
[ ] cspaces++;
. ;
\n cline++;
%%

int yywrap()
{return 1;}

main()
{
yyin=fopen("text1.txt","r");
yylex();
printf("Number of chars are %d \n Number of words are %d \n Number of lines are %d \n Number of spaces are %d \n  ",cchar,cwords,cline,cspaces);
}
