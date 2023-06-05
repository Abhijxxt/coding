#include<stdio.h>
int main()
{
    printf("hello world. This is my first C program");
    //data types
    int a = 10;
    int b = 20;
    double x = 50.0;
    char j1 = '+';
    char j2 = '/';
    char y[] = "result: ";
    printf("If we calculate (%d %c %d) %c %f we get the %s %f",a,j1,b,j2,x,y,((a+b)/x));
    return 0;
}