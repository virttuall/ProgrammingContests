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

const int maxN = 1000;
int N, M, a, b, result;
vector<int> vts;
vector<int> graph[maxN+1];
bool water[maxN+1];
bool visited[maxN+1];
bool visitedF[maxN+1];


void dfs(int node)
{
    if ( water[node] ) return;
    water[node] = true;
    for ( int i = 0; i < graph[node].size(); i++ )
    {
        dfs(graph[node][i]);
    }
}

void dfsF( int node )
{
    if ( visitedF[node] ) return;
    visitedF[node] = true;
    for ( int i = 0; i < graph[node].size(); i++ )
    {
        if ( !water[graph[node][i]] )
        {
            dfsF(graph[node][i]);
        }
    }
}


void topSort( int node )
{
    if ( visited[node] ) return;
    visited[node] = true;
    for ( int i = 0; i < graph[node].size(); i++ )
    {
        if ( !water[graph[node][i]] )
        {
            topSort(graph[node][i]);
        }
    }
    vts.push_back(node);
}
int main()
{
    while(cin>>N)
    {
        s(M);
        for ( int i = 0; i <= N; i++ )
        {
            graph[i] = vector<int>();
            water[i] = false;
            visited[i] = false;
            visitedF[i] = false;
        }
        vts = vector<int>();
        for ( int i = 0; i < M; i++ )
        {
            s(a);
            s(b);
            graph[a].push_back(b);
        }
        dfs(0);
        for ( int i = 1; i <= N; i++ )
        {
            if ( !water[i] && !visited[i])
            {
                topSort(i);
            }
        }
        result = 0;
        for( int i = vts.size()-1; i >= 0; i-- )
        {
            if ( !visitedF[vts[i]] )
            {
                dfsF(vts[i]);
                result++;
            }
        }
        printInt(result);
    }
    return 0;
}
