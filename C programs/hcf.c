#include<stdio.h>
int main()
{
    int a,b,i,hcf=0;
    scanf("%d %d",&a,&b);
    for(int i = (a<b?a:b); i>=1; i--)
    {
        if(a%i==0 && b%i==0)
        {
            hcf = i;
            break;
        }
    }
    printf("%d",hcf);
    return 0;
}