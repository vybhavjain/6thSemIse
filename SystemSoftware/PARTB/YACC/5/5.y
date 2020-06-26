%{
#include<stdio.h>
#include<stdlib.h>
%}

%token num nl

%%
stmt:num nl {printf("\nValid");exit(0);};
%%

int yyerror(char *msg)
{
printf("\nInvalid");
exit(0);
}

main()
{
printf("Enter expression: ");
yyparse();
}

