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

long long N, M;
int k;
long long cof[11];
long long po[11];
set<long long> aSet;


long long getValue( int x )
{
    po[0] = 1;
    po[1] = x;
    for ( int i = 2; i <= k; i++ )
    {
        po[i] = (po[i-1]*x)%N;
    }
    long long result = 0l;
    for( int i = 0; i <= k; i++ )
    {
        result += (cof[i]*po[i])%N;
        result = result % N;
    }
    return result;
}
int main()
{
    while(true)
    {
        sl(N);
        sl(M);
        if ( N == 0 && M == 0) break;
        s(k);
        N++;
        forc( i, k+1)
        {
            scanf("%lld",cof+i);
        }
        aSet = set<long long>();
        for( int i = 0; i <= M; i++ )
        {
            aSet.insert(getValue(i));
        }
        cout<<aSet.size()<<endl;

    }
    return 0;
}
