#include<stdio.h>
#include<stdlib.h> //random function is implemented here
#include<math.h> // for math pow ceil floor
#include<string.h> // for strcpy strcmp string work
#include<stdbool.h> //for boolean

struct Person
{
    char firstName[50];
    char lastName[50];
    int age;
    double rating;// 1 to 5
    char gradePay; //A,B,C
    char bio[100];
}; //struct is like a class with only global variables in java, acting as an object.


void arrays(); /*initialization to remove error while function calling through main.
 Declaring method above main can also be done(PREFERRED)*/ 

void dictionary(); 

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
    bool flag = false;
    
    while (!flag)
    {
        printf("\n\nEntering User Credential system\n");
        printf("Enter your name(Ans:Abhijeet): ");
        scanf("%s",id);
        printf("Enter your password(Ans:Root): ");
        scanf("%s", password);

        //if(id == "Abhijeet" && password == "Root") you can't use this for string
        if(strcmp(id,"Abhijeet")==0 && strcmp(password, "Root") == 0)
        {
            printf("Welcome User. Logged in Successfully.");
            flag = true;
            
        } 
        else if (strcmp(id,"Abhijeet")==0 && strcmp(password, "Root") != 0)
        {
            printf("User id correct but password wrong.");
            
        }
        else
        {
            printf("Login failed.");
            
        }
    }
    
    
    /*
    if() {}
    else if() {}
    else() {}
    can also be used in various situations
    */
}

void Struct() {
    struct Person Person1;
    strcpy(Person1.firstName, "Abhijeet");
    strcpy(Person1.lastName, "Chatterjee");
    strcpy(Person1.bio, "I am an amateur programmer.");
    Person1.age = 19;
    Person1.rating = 4.2;
    Person1.gradePay = 'C';
    printf("Name: %s %s\nAge: %d\nRating: %f\nGrade Pay: %c\nBio: %s",
    Person1.firstName,Person1.lastName, Person1.age, Person1.rating, Person1.gradePay, Person1.bio);
}

void GuessGame() {
    /*
    rand() % (max_number + 1 - minimum_number) + minimum_number
    For random number in range.*/
    int random = rand();
    printf("%d", random);
    bool flag = false;
    int num;
    while(!flag)
    {
        printf("\nGuess the number\n->");
        scanf("%d",&num);
        if(num == random)
        {
            printf("Woohhoooo! You guessed it right!");
            flag = true;
        }
        else
        {
            printf("Wrong. Guess again.");
        }
    }

}

void pointers() {
    int x = 40;
    int * px = &x; //pointers refer to a physical memory location on the computer where data is stored
    printf("\n\nPointer of int x = %d is %p",x,&px); 
    char name[] = "Abhijeet";
    printf("\nPointer of string %s is %p",name,&name);
}

void readFile()
{
    printf("File Reader\n");
    char line[255];
    FILE * fpointer = fopen("data.txt","r");

    fgets(line, 255, fpointer);// another fgets below will read next line of the file
    printf("%s", line);

    fclose(fpointer);
}

void files() {
    //accessing a file through its physical memory location of where it's stored.
    FILE * fpointer = fopen("data.txt", "a");//w- over write, a- append, r- only read
    fprintf(fpointer, "\nHello World.");
    fclose(fpointer);
    printf("\nData entered in the file successfully!\n\n");
    readFile();
}

int main()
{
    //Data type and Inputs
    printf("\nDo you want to enter Data Type and Input section?y/n");
    printf("\n->");
    char x;
    scanf("%c", &x);
    if (x == 'y' || x=='Y')
    {
        DataTypesAndInputs();
    }
    scanf("%c", &x); //Just to bypass auto input

    //Arrays
    printf("\nDo you want to enter Arrays section?y/n");
    printf("\n->");
    char x2;
    scanf("%c", &x2);
    if (x2 == 'y' || x2=='Y')
    {
        arrays();
    }
    scanf("%c", &x); //Just to bypass auto input

    //Credentials( if else if else )
    printf("\nDo you want to enter Credential login section?y/n");
    printf("\n->");
    char x3;
    scanf("%c", &x3);
    if (x3 == 'y' || x3=='Y')
    {
        userIdPass();
    }
    scanf("%c", &x); //Just to bypass auto input
    
    //Name dictionary (Switch case)
    printf("\nDo you want to enter Dictionary section?y/n");
    printf("\n->");
    char x4;
    scanf("%c", &x4);
    if (x4 == 'y' || x4=='Y')
    {
        dictionary();
    }
    scanf("%c", &x); //Just to bypass auto input
    
    //struct usage and learning
    printf("\nDo you want to enter Struct learning section?y/n");
    printf("\n->");
    char x5;
    scanf("%c", &x5);
    if (x5 == 'y' || x5=='Y')
    {
        Struct();
    }
    scanf("%c", &x); //Just to bypass auto input
    
    //Guessing Game(Usage of random)
    printf("\nDo you want to enter Guessing Game?y/n");
    printf("\n->");
    char x6;
    scanf("%c", &x6);
    if (x6 == 'y' || x6=='Y')
    {
        GuessGame();
    }
    scanf("%c", &x); //Just to bypass auto input

    //Pointers 
    pointers();

    //Files
    printf("\nDo you want to enter Files section?y/n");
    printf("\n->");
    char x7;
    scanf("%c", &x7);
    if (x7 == 'y' || x7=='Y')
    {
        files();
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

void dictionary()
{
    //You cant switch names
    printf("\nENTERING DICTIONARY.");
    printf("\nEnter a number from 1-4: \n");
    int number;
    scanf("%d",&number);
    switch (number)
    {
    case 1:
        printf("1 is denoted to the Code creator: Abhijeet Chatterjee");
        break;
    case 2:
        printf("2 is denoted to the girlfriend of Code creator: Soniya Mehra");
        break;
    case 3:
        printf("3 is denoted to the friend of Code Creator: Sanskar Singh");
        break;
    case 4:
        printf("4 is denoted to the gaming buddy of Code Creator: Pranav Dubey");
        break;
    default:
        printf("No one is denoted with this code!");
        break;
    }
}

/*
while(){

}

do{

}while();
*/
