#include<stdio.h>
#include<stdlib.h>
int main()
{
    FILE *pseudocodeFile = fopen("pseudocode.txt","r");
    char ch;
    do{
        ch = fgetc(pseudocodeFile);
        printf("%c", ch);
 
        // Checking if character is not EOF.
        // If it is EOF stop reading.
    } while (ch != EOF);
    
    fclose(pseudocodeFile);
    return 0;
}