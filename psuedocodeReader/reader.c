#include<stdio.h>
#include<stdlib.h>
int main()
{
    FILE *pseudocodeFile = fopen("pseudocode.txt","r");
    char ch;
    do{
        ch = fgetc(pseudocodeFile);
        printf("%c", ch);

        if(ch == '\n')
        {
            printf("new line");
        }
    } while (ch != EOF);
    
    fclose(pseudocodeFile);
    return 0;
}