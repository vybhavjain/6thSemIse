%{
#include<stdio.h>
%}
%token A B
%left A B

%%
S: A S|S B| ;
%%


void yyerror(char *msg)
{
printf("\nInvalid Expression\n");
exit(0);
}

main()
{
printf("Enter an Expression: ");
yyparse();
printf("\nValid Expression\n");
}
