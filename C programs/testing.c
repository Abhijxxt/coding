#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
int main()
{
    double total = 0.0;
    double average = 0.0;
    double totalAvg = 0.0;
    time_t t;
    srand((unsigned) time(&t));
    for(int j = 1; j<=100; j++)
    {
        total = 0;
        average = 0;
        //printf("%f", average);
        
        //printf("entering i loop");
        for(int i = 1; i<=100; i++){
            double x = (rand() % (999 + 1 - 100) + 100 );
            //printf("\n%f", x);
            total = total + x;
        }
        //printf("Exit from i loop");
        average = total / 100;
        totalAvg = totalAvg + average;
        printf("\nAverage Value %d: %f",j, average);
        
    }
    totalAvg = totalAvg/100;
    printf("\n\nfinal total avg: %f", totalAvg);
    return 0;
}