#include <bits/stdc++.h>

#define s(n)    scanf("%d",&n)
#define sc(n)   scanf("%c",&n)
#define sl(n)   scanf("%lld",&n)
#define sf(n)   scanf("%lf",&n)
#define ss(n)   scanf("%s",n)
#define printInt(n) printf("%d\n", n)



#define maX(a,b)    ( (a) > (b) ? (a) : (b))
#define miN(a,b)    ( (a) < (b) ? (a) : (b))

int main()
{
    int a[5];
    int b[5];
    bool flag = true;
    for ( int i = 0; i  < 5; i++ ) scanf("%d", a+i);
    for ( int i = 0; i  < 5; i++ )
    {
        scanf("%d", b+i);
        if ( a[i] == b[i] )
        {
            flag = false;
            break;
        }
    }
    if ( flag ) printf("Y\n");
    else printf("N\n");
    return 0;
}
