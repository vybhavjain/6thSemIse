#include<stdio.h>
#include<string.h>

void main()
{
	FILE *f1,*f2,*f3,*f4;//4 file pointers
	char label[20],opcode[20],operand[20];
	int address,sa,i;
	f1=fopen("output.txt","r");//output of pass1 
	f4=fopen("output2.txt","w");//output generated from pass2 (contains object codes)
	fscanf(f1,"%x %s %s %s",&address,label,opcode,operand);//read from pass1 
	if(strcmp(opcode,"START")==0)//find start
	{
		fprintf(f4,"%X\t%s\t%s\t%s\t-\n",address,label,opcode,operand);//- since start doesnt have objcode
		sa=address;//start address 
	}
	fscanf(f1,"%x %s %s %s",&address,label,opcode,operand);//read next line from pass1 output
	while(strcmp(opcode,"END")!=0)//while not the END 
	{
		fprintf(f4,"%X\t%s\t%s\t%s\t",address,label,opcode,operand);//write the pass1 results into output
		
		f2=fopen("optab1.txt","r");//open optab and read
		char tempcode[20],tempval[20];
		fscanf(f2,"%s %s",tempcode,tempval);//read from optab
		while(!feof(f2))//while its not an end of file
		{
			if(strcmp(opcode,tempcode)==0)//if operation code is found 
			{
				fprintf(f4,"%s",tempval);//write the opcode
				break;//exit 
			}
			else
				fscanf(f2,"%s %s",tempcode,tempval);//else just read and continue
		}
		fclose(f2);//close optab1
		
		char actoperand[20];//actual operand to write into output 
		strcpy(actoperand,"");//copy blank
		if(operand[strlen(operand)-1]=='X')//if indexed,get substring until comma
		{
			int i;
			for(i=0;i<strlen(operand)-2;i++)
				actoperand[i]=operand[i];//find operand,copy into actoperand
			actoperand[i]='\0';//terminate with null
		}
		else
			strcpy(actoperand,operand);//if not indexed,straight copy
			
		f3=fopen("symtab.txt","r");//symbol table in read mode
		char symcode[20],symval[20];
		fscanf(f3,"%s %s",symcode,symval);//read from symtab
		while(!feof(f3))//while not EOF of symtab
		{
			if(strcmp(actoperand,symcode)==0)//if actual operand is found in symtab
			{
				
				int lval=strtol(symval,NULL,16);//convert to base16(hex)
				if(operand[strlen(operand)-1]=='X')//if indexed 
					lval=lval+0x8000;//make x bit 1
				fprintf(f4,"%X\n",lval);//write value in hex 
				break;
			}
			else
				fscanf(f3,"%s %s",symcode,symval);//read from symtab
		}
		fclose(f3);//close symtab

		if(strcmp(opcode,"WORD")==0)//if WORD
		{
			int val=strtol(operand,NULL,16);//convert to hex
			char num[10];
			sprintf(num,"%X",val);
			int l=strlen(num);
			while(l<6)//print out the zeroes to make it 6 digits long (format 3)
			{
				fprintf(f4,"0");
				l++;
			}
			fprintf(f4,"%s\n",num);//finally print the number
		}

		if(strcmp(opcode,"BYTE")==0)
		{
			if(operand[0]=='X')//for hex
			{
				for(i=2;i<strlen(operand)-1;i++)
					fprintf(f4,"%c",operand[i]);
				fprintf(f4,"\n");
			}
			else if(operand[0]=='C')//character string
			{
				for(i=2;i<strlen(operand)-1;i++)
					fprintf(f4,"%02X",operand[i]);//operand boiled down to 2 digits
				fprintf(f4,"\n");
			}
		}
		
		if(strcmp(opcode,"RESB")==0||strcmp(opcode,"RESW")==0)
			fprintf(f4,"-\n");//no code for RESB and RESW		
		fscanf(f1,"%x %s %s %s",&address,label,opcode,operand);//next scan
	}
	fprintf(f4,"%X\t%s\t%s\t%s\n",address,label,opcode,operand);//print last end record	
	fclose(f1);
	fclose(f4);
}
