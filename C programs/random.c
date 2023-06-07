#include<stdio.h>
int main()
{
    int ran; //when non initialized variable is printed garbage value is printed.
    printf("%d", ran/1000);
    return 0;
}