#include<stdio.h>
int value = 0;
struct Person
{
    char name[50];
    int age;
    char gradePay; // a,b,c
    double rating;
};

void talk(struct Person person, int val)
{
    printf("Hello world this is a person");
    printf("\nName: %s\nAge: %d\nGrade Pay: %c\nRating: %f", 
    person.name,person.age,person.gradePay,person.rating);
    printf("\nValue changed from Office program to Person program: %d, %d",val,value);
}
