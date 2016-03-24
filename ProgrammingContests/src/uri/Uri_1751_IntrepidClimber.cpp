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

int N, F, a, b, v, sonMax;
const int maxN = 100000;
const int maxF = 100000;

vector<int> graphSon[maxN+1];
vector<int> graphSize[maxN+1];


bool flags[maxN+1];
int total[maxN+1];
int maX[maxN+1];

void f(int node)
{
    int son, sizeS;
    for( int i = 0; i < graphSon[node].size(); i++ )
    {
        son = (graphSon[node])[i];
        sizeS = (graphSize[node])[i];
        f( son );
        if ( flags[son] )
        {
            flags[node] = true;
            total[node] += total[son] + sizeS;
            maX[node] = maX(maX[node], maX[son]+sizeS);
        }
    }
}
int main()
{
    fill_n(flags, maxN+1, false);
    fill_n(total, maxN+1,0);
    fill_n(maX, maxN+1, 0);
    s(N); s(F);
    for ( int i = 0; i  < N -1; i++ )
    {
        s(a); s(b); s(v);
        graphSon[a].push_back(b);
        graphSize[a].push_back(v);
    }

    for( int i = 0; i < F; i++ )
    {
        s(v);
        flags[v] = true;
    }
    f(1);

    /*for( int  i = 1; i <= N; i++ )
    {
        printf("i:%d total:%d max:%d\n", i, total[i], maX[i]);
    }*/
    sonMax = -1;
    int son;
    int sizeS;
    int maxM = -1;
    for ( int i = 0; i <  graphSon[1].size(); i++ )
    {
        son = (graphSon[1])[i];
        sizeS = (graphSize[1])[i];
        //printf("-- %d\n", maX[son]+sizeS);
        if ( maxM < maX[son] + sizeS && flags[son])
        {
            sonMax = son;
            maxM = maX[son]+sizeS;
        }
    }
    int sum = 0;
    //printInt(sonMax);
    for ( int i = 0; i <  graphSon[1].size(); i++ )
    {
        son = (graphSon[1])[i];
        sizeS = (graphSize[1])[i];
        if ( son != sonMax )
        {
            if ( flags[son])
                sum += total[son]+sizeS;
        }
        else
        {
            sum+= total[son]-maX[son];
        }
    }
    printInt(sum);
    return 0;
}
