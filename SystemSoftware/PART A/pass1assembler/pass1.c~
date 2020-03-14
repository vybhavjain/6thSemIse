#include<stdio.h>
#include<string.h>
#include<stdlib.h>

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
		{
			fprintf(f3,"%s\t%X\n",label,lc);//write into symtab
		}
		
		char tempcode[20],tempval[20];
		f2=fopen("optab1.txt","r");
		fscanf(f2,"%s %s",tempcode,tempval);
		while(!feof(f2))
		{
			if(strcmp(opcode,tempcode)==0)
			{
				lc+=3;
				break;
			}
			fscanf(f2,"%s %s",tempcode,tempval);
		}
		fclose(f2);

		if(strcmp(opcode,"WORD")==0)
		{
			lc+=3;
		}

		if(strcmp(opcode,"RESW")==0)
		{
			lc=lc+(3*(strtol(operand,NULL,10)));
		}

		if(strcmp(opcode,"RESB")==0)
		{
			lc=lc+strtol(operand,NULL,10);
		}

		if(strcmp(opcode,"BYTE")==0)
		{
			if(operand[0]=='X')
				lc++;
			else
				lc=lc+strlen(operand)-3;
		}
		fscanf(f1,"%s %s %s",label,opcode,operand);
	}
	fprintf(f4,"%X\t%s\t%s\t%s\n",lc,label,opcode,operand);

	printf("\nOutput File generated as output.txt\n");
	fclose(f1);
	fclose(f4);
	fclose(f3);
}
