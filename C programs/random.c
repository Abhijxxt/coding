#include<stdio.h>
#include<stdbool.h>
#define PI 3.1415
int main()
{
    int ran; //when non initialized variable is printed garbage value is printed.
    printf("%d", ran/1000);

    double val;
    printf("\nEnter a decimal value: ");
    scanf("%lf", &val); //for double input use lf 
    printf("%.2f", val); //for n decimal points .n is used
    
    bool x = PI == 3.1415;
    printf("\nBoolean %d",x);
    return 0;
}