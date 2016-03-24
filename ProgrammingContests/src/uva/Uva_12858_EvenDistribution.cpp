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

const int maxGCD = 100000;
const int maxNode = 10000;
int I, S, a, b;
int CS[maxNode+1];
vector<int> graph[maxNode+1];
bool ok[maxGCD+1];
int countOk;
queue< pair<int,int> > q; // (node, gcd)
int node;
int gcd;
int newGcd;
pair<int, int> auxPair;
int neighbour;
set< pair<int, int> > s;

int GCD(int a,int b)
{
    if ( a== 0) return b;
    else GCD(b%a, a);
}
int main()
{
    while(cin>>I)
    {
        s(S);
        fill_n(ok, maxGCD+1, false);
        s = set< pair< int, int> >();
        countOk = 0;
        for( int i = 1; i <= maxNode; i++ ) graph[i] = vector<int>();
        for ( int i = 1; i <= I; i++ )
        {
            scanf("%d", CS + i);
        }
        for ( int i = 0; i < S; i++ )
        {
            s(a); s(b);
            graph[a].push_back(b);
            graph[b].push_back(a);
        }
        for ( int i = 1; i <= I; i++ )
        {
            //dfs of node i
            q = queue< pair<int, int> >();
            q.push(make_pair(i, CS[i]));
            while( !q.empty() )
            {
                auxPair = q.front();
                q.pop();
                node = auxPair.first;
                gcd = auxPair.second;
                //printf("node: %d, gcd: %d\n", node,gcd);
                if ( s.count(make_pair(node, gcd)) != 0 )
                    continue;
                s.insert(make_pair(node, gcd));
                if (!ok[gcd])
                {
                    ok[gcd] = true;
                    //printInt(gcd);
                    countOk++;
                }
                for( int j = 0; j < graph[node].size(); j++ )
                {
                    neighbour = graph[node][j];
                    newGcd = GCD(CS[neighbour],gcd);
                    //printf("in GCD with %d: %d %d\n", neighbour,CS[neighbour], gcd);
                    q.push(make_pair(neighbour, newGcd));
                }
            }

        }
        printInt(countOk);
    }
    return 0;
}
