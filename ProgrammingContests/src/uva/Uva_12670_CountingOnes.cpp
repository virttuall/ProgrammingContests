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

long long A, B;
long long pow2[65];


long long M(long long a)
{
    long long result = 0l;
    while( a != 0l )
    {
        a = a >> 1l;
        result = result + 1l;
    }
    return result;
}
long long countOnes( long long a)
{
    if ( a == 0l) return 0l;
    long long N = M(a);
    long long R = a - (1l << (N-1l));
    return pow2[int(N)]+(R)+countOnes(R);
}
int main()
{
    pow2[1] = 1;
    for( long i = 1; i < 64; i++ )
    {
        pow2[int(i)+1] = i*(1l << (i -1l))+1l;
    }
    long long rs;
    while(cin>>A)
    {
        cin>>B;
        rs = countOnes(B)-countOnes(A-1);
        cout<<rs<<endl;
    }
    return 0;
}
