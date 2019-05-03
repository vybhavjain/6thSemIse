%{
#include<stdio.h>
int cvowel = 0,cconsonant = 0,cnumber = 0,cline = 0,cspecial = 0;
%}

%%
[ ] ;
[aeiouAEIOU] {cvowel++;printf("Vowel detected");}
[a-zA-Z] {cconsonant++;printf("consonant detected");}
[0-9] {cnumber++;printf("number detected");}
. {cspecial++;printf("special detected");}
\n {cline++;printf("line detected");}
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
printf("Number of vowels are %d \n Number of consonants are %d \n Number of numbers are %d \n Number of special are %d \n Number of lines are %d \n ",cvowel,cconsonant,cnumber,cspecial,cline);
}
