#include<stdio.h>
#include<string.h>

void main()
{
        FILE *f1; //file pointer 
        f1=fopen("try1.txt","r");//open file to read
        char type,objcode[20],progname[20],input[20];
        int sa,addr,len;
        fscanf(f1,"%c %s %x %x",&type,progname,&sa,&len);//for H record
        printf("Loading Program %s of length %X starting at Address %X :-\n",progname,len,sa);
        fscanf(f1,"%s",input);//storing next rext record (T) into input
        while(strcmp(input,"E")!=0)//while its not the (E) record
        {
                if(strcmp(input,"T")==0)//if text record
                {
                        fscanf(f1,"%X",&addr);//starting addr in hex
                        fscanf(f1,"%X",&len);//length in hex
                        fscanf(f1,"%s",input);//the first instruction
                }
                int i=0;
                while(i<strlen(input)-1)//from start to end in object codes of text record
                {
                        printf("%X\t%c%c\n",addr,input[i],input[i+1]);//for every byte, printing the address
                        addr++;//incrementing address by 1
                        i+=2;//moving every byte
                }
                fscanf(f1,"%s",input);//taking next string in object program
        }
        fclose(f1);//close file 
}
