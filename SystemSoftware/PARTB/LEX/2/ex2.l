//Comment : This program is to check single line comments and multi comment lines.

%{
#include<stdio.h>
int ccomment=0;
int multicomment=0;
%}

%%

[\/][\/] {ccomment++;}
"/*"[^("*/")]+"*/" {multicomment++;ECHO;}

%%

int yywrap()
{return 1;}

main(int argc, char *argv[])
{
if(argc!=2){
exit(0);
}
yyin=fopen(argv[1],"r");
yylex();
printf("Number of comments %d\n",ccomment);
printf("Number of multicomments %d\n",multicomment);

}
