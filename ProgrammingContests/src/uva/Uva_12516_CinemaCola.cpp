#include <bits/stdc++.h>

#define s(n)    scanf("%d",&n)
#define sc(n)   scanf("%c",&n)
#define sl(n)   scanf("%lld",&n)
#define sf(n)   scanf("%lf",&n)
#define ss(n)   scanf("%s",n)
#define printInt(n) printf("%d\n", n)



#define maX(a,b)    ( (a) > (b) ? (a) : (b))
#define miN(a,b)    ( (a) < (b) ? (a) : (b))

#define forall(i, a, b)  for( int i = a; i <= b; i++ )
#define forc(i, f) for( int i = 0; i < f; i++ )

using namespace std;

int R, C, P, Z;
char d, s;
bool flags[26][100], flag;
bool friends[26][99];
int n;

int main()
{
    while(true)
    {
        scanf("%d %d\n", &R, &C);
        for( int i = 0; i<  26; i++ ) fill_n(flags[i], 100, false);
        for( int i = 0; i<  26; i++ ) fill_n(friends[i], 99, false);
        if ( R == 0 && C == 0) break;
        scanf("%d\n", &P);
        forc(i, P)
        {
            scanf("%c%d %c\n", &d, &n, &s);
            if ( s == '+')  flags[d-'A'][n] = true;
            else flags[d-'A'][n-1] = true;
        }
        scanf("%d\n",&Z);
        flag = true;
        for( int i = 0; i <  Z; i++ )
        {
            scanf("%c%d\n", &d, &n);
            friends[d-'A'][n-1] = true;
        }
        for( int i = 0; i < 26 && flag; i++ )
        {
            for( int j = 0; j < 99; j++ )
            {
                if ( friends[i][j] )
                {
                    if ( flags[i][j] && flags[i][j+1])
                    {
                        flag = false;
                        break;
                    }
                    else
                    {
                        if ( !flags[i][j] ) flags[i][j] = true;
                        else flags[i][j+1] = true;

                    }
                }
            }
        }
        if ( flag) printf("YES\n");
        else printf("NO\n");
    }
    return 0;
}
