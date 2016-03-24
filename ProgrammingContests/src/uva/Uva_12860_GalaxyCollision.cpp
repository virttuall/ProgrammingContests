
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

const int maxV = 500000;
int N, x, y, xx, yy;
set< int > sets[maxV+1];
vector< int > graph[maxV+1];
map< pair<int, int> , int > m;
int xs[maxV+1];
int ys[maxV+1];
int nx[100];
int ny[100];
bool visited[maxV+1];
queue<int> aQueue;
queue<int> aQueueV;

int main()
{
    double d;
    int c = 0;
    for ( int i = -5; i <= 5; i++ )
    {
        for ( int j = -5; j <= 5; j++ )
        {
            d = hypot(abs(i), abs(j));
            if ( d <= 5.0 && d != 0)
            {
                //printf("%d %d\n", i, j);
                nx[c] = i;
                ny[c++] = j;
            }

        }
    }
    while(cin>>N)
    {
        m = map< pair<int, int> , int >();
        for ( int i = 0; i  <= maxV ; i++ )
        {
            graph[i] = vector<int>();
            sets[i] = set<int>();
        }
        for ( int i = 0; i < N; i++ )
        {
            s(x); s(y);

            xs[i] = x;
            ys[i] = y;
            m[make_pair(x, y)] =  i;
            sets[x].insert(y);

        }

        for( int i = 0; i < N; i++ )
        {
            x = xs[i];
            y = ys[i];
            for( int j = 0; j  <  c; j++ )
            {
                xx = x + nx[j];
                yy = y + ny[j];
                if ( xx < 1 || x > 500000 || y < 1 || x > 500000 ) continue;

                if ( sets[xx].count(yy) != 0 )
                {
                    graph[m[make_pair(x, y)]].push_back(m[make_pair(xx, yy)]);
                }
            }
        }

        fill_n(visited, maxV+1, false );
        int result = 0;
        int col;
        int tot;
        int node;
        int val;
        for ( int i = 0; i < N; i++ )
        {
            if ( !visited[i] )
            {
                col = 0;
                tot = 0;
                aQueue = queue<int>();
                aQueueV = queue<int>();
                aQueue.push(i);
                aQueueV.push(0);
                while( !aQueue.empty() )
                {
                    node = aQueue.front();
                    aQueue.pop();
                    val = aQueueV.front();
                    aQueueV.pop();
                    if ( visited[node] ) continue;
                    visited[node] = true;
                    tot++;
                    if ( val % 2  == 0) col++;
                    for ( int j =0 ; j < graph[node].size(); j++ )
                    {
                        aQueue.push(graph[node][j]);
                        aQueueV.push(val+1);
                    }
                }
                result += miN(col, tot-col);
            }
        }
        printInt(result);
    }
    return 0;
}
