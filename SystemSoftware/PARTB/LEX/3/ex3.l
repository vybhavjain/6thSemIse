%{
#include<stdio.h>
#include<string.h>
int top=-1,v=1,i=0,j=0;
char a[20],opt[20][10],opnd[20][10];
%}
%%
"("	{a[++top]='(';}
"{"	{a[++top]='{';}
"["	{a[++top]='[';}

")"	{
		if(a[top]=='(')
			top--;
		else
		{
			v=0;
			return 1;
		}
	}
"}"	{
		if(a[top]=='{')
			top--;
		else
		{
			v=0;
			return 1;
		}
	}
"]"	{
		if(a[top]=='[')
			top--;
		else
		{
			v=0;
			return 1;
		}
	}

"+"|"-"|"*"|"/"	{strcpy(opt[i++],yytext);}

[0-9]*	{strcpy(opnd[j++],yytext);}
"\n"     {return;}
%%
int yywrap()
{return 1;}
void yyerror(char *s) {
    fprintf(stderr, "line %d: %s\n", yylineno, s);
}
int main()
{
	printf("\nEnter an Expression: ");
	yylex();
	if(v && j>i)
	{
		printf("\nValid Expression\n");
		printf("\nOperators used are:-\n");
		for(int k=0;k<i;k++)
			printf("%s\n",opt[k]);
		printf("\nOperands used are:-\n");
		for(int k=0;k<j;k++)
			printf("%s\n",opnd[k]);
	}
	else
		printf("\nNot a Valid Expression!\n");
	return 0;
}
