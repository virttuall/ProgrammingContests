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

const int maxM = 1000;
int M, Q;
char DB[maxM][100], arr[maxM];
int lDB[maxM];
int l;
int maxV, auxMax;
int id, mV, v;

int f( int i)
{
    if ( l > lDB[i]) return -1;
    mV = -1;
    forc(j, lDB[i] - l + 1)
    {
        v = 0;
       forc(k, l)
       {
            if ( DB[i][j+k] == arr[k] )
            {
                v++;
            }
       }
       mV = maX(mV, v);
    }
    return mV;
}
int main()
{
    s(M); s(Q);
    forc(i, M)
    {
       scanf("%s", DB[i]);
       lDB[i] = strlen(DB[i]);
    }
    forc(i, Q)
    {
        scanf("%s", arr);
        l = strlen(arr);
        maxV = -1;
        id = -1;
        forc(j, M)
        {
            auxMax = f(j);
            if ( auxMax > maxV )
            {
                maxV = auxMax;
                id = j;
            }
        }
        printInt(id+1);
    }
    return 0;
}
