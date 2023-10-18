#include<stdio.h>
int main()
{
    int a,b,i,lcm=0;
    printf("Enter numbers \a: ");
    scanf("%d %d",&a,&b);
    for(i = (a>b?a:b); i<=a*b; i++)
    {
        if(i%a==0 && i%b==0)
        {         
            lcm = i;
            break;    
        }   
    }
    printf("%d",lcm);
    return 0;
}