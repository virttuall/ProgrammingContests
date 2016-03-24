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

int p1, p2;
bool angles[361];
int m, v;

int main()
{
    fill_n(angles, 361,false);
    for( int i = 0; i < 720; i++ )
    {
        p1 = (6*i)%360;
        p2 = 6*(i/12);
        m = abs(p1 - p2);
        m = miN(m , 360 - m);
        angles[m] = true;
    }
    while(cin>>v)
    {
        if ( angles[v] ) printf("Y\n");
        else printf("N\n");
    }
    return 0;
}
