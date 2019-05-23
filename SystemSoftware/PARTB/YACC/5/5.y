%{
#include<stdio.h>
#include<stdlib.h>
%}

%token num nl

%%
stmt:num nl {printf("valid \n");exit(0);};
%%

int yyerror(char *msg)
{
printf("invalid");
exit(0);
}

main()
{
printf("enter expression");
yyparse();
}

