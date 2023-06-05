#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>

void arrays(); /*initialization to remove error while function calling through main.
 Declaring method above main can also be done(PREFERRED)*/ 

void DataTypesAndInputs()
{
    printf("hello world. This is my first C program");
    //data types
    float notUsedVariable = 25.222;
    int a = 10;
    int b = 20;
    double x = 50.0;
    const char j1 = '+';
    const char j2 = '/';
    char y[] = "result: ";
    printf("If we calculate (%d %c %d) %c %f we get the %s %f",a,j1,b,j2,x,y,((a+b)/x));
    printf("Power of 2 to 5 times is %f", pow(2,5)); //sqrt, ceil, floor

    //inputs
    char name[50];
    int age= 0;
    double value = 0;
    
    printf("Entering inputs section.\nEnter your first name: ");//program fails with spaces in input(Programming Language problem)
    scanf("%s",name); //you don't need & with string inputs
    printf("Enter your age: ");
    scanf("%d", &age);
    printf("Welcome. %s. Nice to know you are %d", name, age);

    printf("\nEnter a decimal value: ");
    scanf("%lf",&value);// while inputting you use %lf instead of %f
    printf("Value: %f", value);
    
    //Inputting strings with spaces 
    /*(Programming Language problem) fgets malfunctions if used after scanf due to the fact that scanf leaves a new line which 
    fgets read and executes itself automatically without taking any real input.
    Currently working on to find a solution to that
    fgets store Enter key sequence as \n in the variable and when printed at any point string after variable would be on new line
    */
    char sentence[100];
    printf("\n\nEnter a string without worrying about code breaking: ");
    fgets(sentence,100,stdin);//using one more fgets just to bypass auto inputting as explained above
    //this can be compared to JAVA's scanner String input problem as I have faced in earlier days. 
    fgets(sentence,100, stdin);
    printf("%s", sentence);

    //Another way of taking input with spaces(RESTRICTED TO ONLY FINITE NUMBER OF WORDS)
    char val1[100];
    char val2[100];
    printf("\n\nEnter your full name(2 words only): ");
    scanf("%s%s", val1, val2); //Each space will act as a breaking point and will add further string to another variable
    /*Number of %s should be less than equal to what is being inputted if you have to input 100 word sentence you would have 
    to use %s in scanf 100 times which is not feasible!*/
    printf("Name: %s %s", val1, val2);


}

void userIdPass()
{
    char id[10];
    char password[10];
    printf("\n\nEntering User Credential system\n");
    printf("Enter your name(Ans:Abhijeet): ");
    scanf("%s",id);
    printf("Enter your password(Ans:Root): ");
    scanf("%s", password);

    //if(id == "Abhijeet" && password == "Root") you can't use this for string
    if(strcmp(id,"Abhijeet")==0 && strcmp(password, "Root") == 0)
    {
        printf("Welcome User. Logged in Successfully.");
    } 
    else
    {
        printf("Login failed.");
    }
}

int main()
{
    //Data type and Inputs
    printf("\nDo you want to enter Data Type and Input section?y/n");
    printf("\nPRESS ENTER TO SKIP AS WELL\n->");
    char x;
    scanf("%c", &x);
    if (x == 'y' || x=='Y')
    {
        DataTypesAndInputs();
    }
    scanf("%c", &x); //Just to bypass auto input
    //Arrays
    printf("\nDo you want to enter Arrays section?y/n");
    printf("\nPRESS ENTER TO SKIP AS WELL\n->");
    char x2;
    scanf("%c", &x2);
    if (x2 == 'y' || x2=='Y')
    {
        arrays();
    }
    scanf("%c", &x); //Just to bypass auto input
    //Credentials
    printf("\nDo you want to enter Credential login section?y/n");
    printf("\nPRESS ENTER TO SKIP AS WELL\n->");
    char x3;
    scanf("%c", &x3);
    if (x3 == 'y' || x3=='Y')
    {
        userIdPass();
    }
    scanf("%c", &x); //Just to bypass auto input
    

    return 0;
}

void arrays()
{
    printf("\n\nENTERING ARRAYS SECTION.\n");
    int numArr[] = {11,22,33,44,55};
    //char stringArr[][] = {"Abhijeet", "Chatterjee"};

    printf("Value at 0 position is %d", numArr[0]);
    //printf("%s", stringArr[0]);
}