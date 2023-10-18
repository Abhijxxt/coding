/*
*****
 ****
  ***
   **
    *
*/
#include<stdio.h>
int main()
{
    for(int i=1 ; i<=5; i++)
    {
        for(int x=1; x<i; x++)
        {
            printf(" ");
        }
        for(int j=i; j<=5; j++)
        {
            printf("*");
        }
        printf("\n");
    }
    return 0;
}
