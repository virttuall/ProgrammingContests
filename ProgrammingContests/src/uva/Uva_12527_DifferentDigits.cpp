#include <bits/stdc++.h>

#define s(n)    scanf("%d",&n)
#define sc(n)   scanf("%c",&n)
#define sl(n)   scanf("%lld",&n)
#define sf(n)   scanf("%lf",&n)
#define ss(n)   scanf("%s",n)
#define printInt(n) printf("%d\n", n)



#define maX(a,b)    ( (a) > (b) ? (a) : (b))
#define miN(a,b)    ( (a) < (b) ? (a) : (b))

using namespace std;

const int maxM = 5000;
bool flags[maxM+1][10];
bool flag;
int value;
int c[maxM+1];
int M, N;

int main()
{
    for( int i = 0; i <= maxM; i++ ) for( int j = 0; j < 10; j++ ) flags[i][j] = false;
    fill_n(c, maxM+1, 0);
    for( int i = 1; i <= maxM; i++ )
    {
        value = i;
        flag = true;
        while( value != 0)
        {
            if ( flags[i][value % 10] )
            {
                flag = false;
                break;
            }
            else
            {
                flags[i][value % 10] = true;
                value = value / 10;
            }
        }
        c[i] = c[i-1];
        if ( flag )
        {
            c[i]++;
        }
    }
    while(cin>>N)
    {
        s(M);
        printInt(c[M]-c[N-1]);
    }
    return 0;
}
