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
const int maxN = 100000;
int a[maxN], listFaults[maxN];
int n, faults, maxV;
int main()
{
    while(cin>>n)
    {
        faults = 0;
        for( int i = 0; i <  n; i++ ) scanf("%d", a+i);
        listFaults[faults++] = 0;
        for ( int i= 1; i < n; i++ )
        {
            if ( a[i-1] > a[i] )
            {
                listFaults[faults++] = i;
            }
        }
        listFaults[faults++] = n;
        if ( faults == 2 )
        {
            printInt(n);
        }
        else
        {
            maxV = 0;
            for ( int i = 1; i <  faults-1; i++ )
                maxV = maX(maxV, listFaults[i+1]-listFaults[i-1]);
            printInt(maxV);
        }
    }
    return 0;
}



