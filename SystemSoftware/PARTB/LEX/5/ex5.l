%{
#include<stdio.h>
int pcount = 0;
int ncount = 0;
int pdec = 0;
int ndec = 0;
%}

%%
[/+]?[0-9]+ {pcount++;ECHO;}
[/-][0-9]+ {ncount++;ECHO;}
[/+]?[0-9]+[/.][0-9]+ {pdec++;ECHO;}
[/-][0-9]+[/.][0-9]+ {ndec++;ECHO;}
%%

int yywrap()
{return 1 ;}

main()
{
yylex();
printf("Number of positive numbers are : %d \n Number of negative numbers are : %d \n",pcount,ncount);
printf("Number of positive decimals are : %d \n Number of negative decimals are : %d \n",pdec,ndec);
}
