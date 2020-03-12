#include<stdio.h>
#include<string.h>

void main()
{
	FILE *f1,*f2,*f3,*f4; //4 file pointers
	f1=fopen("input.txt","r"); //input file having SIC code
	f3=fopen("symtab.txt","w"); //symbol table
	f4=fopen("output.txt","w");//output file containing locations
	int lc,sa;//lc=location,sa=start location
	char label[20],opcode[20],operand[20];
	
	fscanf(f1,"%s %s %s",label,opcode,operand);//read from file input.txt

	if(strcmp(opcode,"START")==0)//if start
	{
		sa=strtol(operand,NULL,16);//covert string to hex
		fprintf(f4,"%X\t%s\t%s\t%s\n",sa,label,opcode,operand);//write into output file 
	}
	else
		sa=0;//intially if not mentioned
	lc=sa;

	fscanf(f1,"%s %s %s",label,opcode,operand);//read from input
	while(strcmp(opcode,"END")!=0)//until end instruction
	{
		fprintf(f4,"%X\t%s\t%s\t%s\n",lc,label,opcode,operand);//write into output file
		
		if(strcmp(label,"*")!=0)//if * means no label, don't write into symtab
			fprintf(f3,"%s\t%X\n",label,lc);//write into symtab
		
		char tempcode[20],tempval[20];//stores contents of optab1; code, code id
		f2=fopen("optab1.txt","r");//f2 for obtab1 
		fscanf(f2,"%s %s",tempcode,tempval);//read from optab1
		while(!feof(f2))//while not end of file
		{
			if(strcmp(opcode,tempcode)==0)//compare the opcode and codes in optab1
			{
				lc+=3;//default increment 3,format 3 instructions
				break;
			}
			fscanf(f2,"%s %s",tempcode,tempval);//read the next instruction 
		}
		fclose(f2);//close optab1

		if(strcmp(opcode,"WORD")==0)//if opcode is WORD
			lc+=3;//add 3

		if(strcmp(opcode,"RESW")==0)
			lc=lc+(3*(strtol(operand,NULL,10)));//convert to decimal , multiply by 3 and add to lc

		if(strcmp(opcode,"RESB")==0)
			lc=lc+strtol(operand,NULL,10);//convert to decimal and add to lc

		if(strcmp(opcode,"BYTE")==0)//if opcode is byte
		{
			if(operand[0]=='X')//if hex 
				lc++;
			else
				lc=lc+strlen(operand)-3;//if string of char (c'eof')
		}
		fscanf(f1,"%s %s %s",label,opcode,operand);//default read from input
	}
	fprintf(f4,"%X\t%s\t%s\t%s\n",lc,label,opcode,operand);//write into output the final instruction E

	printf("Output File generated as output.txt\n");//generate output 
	fclose(f1);
	fclose(f4);
	fclose(f3);//close all files
}
