%{
#include<stdio.h>
int cvowel = 0,cconsonant = 0,cnumber = 0,cline = 0,cspecial = 0;
%}

%%
[ ] ;
[aeiouAEIOU] {cvowel++;printf("Vowel detected\n");}
[a-zA-Z] {cconsonant++;printf("consonant detected\n");}
[0-9] {cnumber++;printf("number detected\n");}
. {cspecial++;printf("special detected\n");}
\n {cline++;printf("line detected\n");}
%%

int yywrap()
{return 1;}

main(int argc, char *argv[])
{
yyin=fopen("text.txt","r");
yylex();
printf("Number of vowels are %d \n Number of consonants are %d \n Number of numbers are %d \n Number of special are %d \n Number of lines are %d \n ",cvowel,cconsonant,cnumber,cspecial,cline);
}
