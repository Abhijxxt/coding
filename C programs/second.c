#include<stdio.h>

int main()
{
    printf("Sample info.");

    char name[] = "Abhijeet Chatterjee";
    int age = 19;
    char grade = 'A';
    float cgpa = 9.5;

    printf("Welcome %s.\nYour age: %d\nYour grade: %c\nYour percentage: %f",name, age, grade, cgpa);
    
    char answer = 'n';

    printf("\nDo you want to enter data?");
    scanf("%c",&answer);

    if (answer == 'y')
    {
        
        char newName[50] = "";
        int newAge;
        char newGrade;
        float newCgpa;

        printf("Enter name: ");
        fgets(newName, 50, stdin);

        printf("Enter age: ");
        scanf("&d", &newAge);
        
        printf("Enter grade: ");
        scanf("&c", &newGrade);
    
        printf("Enter CGPA: ");
        scanf("&f", &newCgpa);

        printf("Welcome %s.\nYour age: %d\nYour grade: %c\nYour percentage: %f", newName, newAge, newGrade, newCgpa);
    }
    else
    {
        printf("Program will be exiting here.");
    }
    return 0;
}