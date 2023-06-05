#include "Person.h"
#include<stdio.h>
#include<string.h>
int main()
{
    value = 100;
    struct Person Person1;
    strcpy(Person1.name, "Abhijeet");
    Person1.age = 19;
    Person1.rating = 4.2;
    Person1.gradePay = 'B';
    talk(Person1,value);
    return 0;
}