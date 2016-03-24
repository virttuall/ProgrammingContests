#include <bits/stdc++.h>

#define s(n)    scanf("%d",&n)
#define sc(n)   scanf("%c",&n)
#define sl(n)   scanf("%lld",&n)
#define sf(n)   scanf("%lf",&n)
#define ss(n)   scanf("%s",n)
#define printInt(n) printf("%d\n", n)



#define maX(a,b)    ( (a) > (b) ? (a) : (b))
#define miN(a,b)    ( (a) < (b) ? (a) : (b))


const int maxN = 100;
char table[maxN+1][maxN+1];
int rows[maxN+1][maxN+1];
int columns[maxN+1][maxN+1];

using namespace std;


namespace hopcroftKarp {

	const int MAXN1 = 50000;
	const int MAXN2 = 50000;
	const int MAXM = 150000;

	int n1, n2, edges, last[MAXN1], prev[MAXM], head[MAXM];
	int matching[MAXN2], dist[MAXN1], Q[MAXN1];
	bool used[MAXN1], vis[MAXN1];

	void init(int _n1, int _n2) {
		n1 = _n1;
		n2 = _n2;
		edges = 0;
		fill(last, last + n1, -1);
	}

	void addEdge(int u, int v) {
		head[edges] = v;
		prev[edges] = last[u];
		last[u] = edges++;
	}

	void bfs() {
		fill(dist, dist + n1, -1);
		int sizeQ = 0;
		for (int u = 0; u < n1; ++u) {
			if (!used[u]) {
				Q[sizeQ++] = u;
				dist[u] = 0;
			}
		}
		for (int i = 0; i < sizeQ; i++) {
			int u1 = Q[i];
			for (int e = last[u1]; e >= 0; e = prev[e]) {
				int u2 = matching[head[e]];
				if (u2 >= 0 && dist[u2] < 0) {
					dist[u2] = dist[u1] + 1;
					Q[sizeQ++] = u2;
				}
			}
		}
	}

	bool dfs(int u1) {
		vis[u1] = true;
		for (int e = last[u1]; e >= 0; e = prev[e]) {
			int v = head[e];
			int u2 = matching[v];
			if (u2 < 0 || !vis[u2] && dist[u2] == dist[u1] + 1 && dfs(u2)) {
				matching[v] = u1;
				used[u1] = true;
				return true;
			}
		}
		return false;
	}

	int maxMatching() {
		fill(used, used + n1, false);
		fill(matching, matching + n2, -1);
		for (int res = 0;;) {
			bfs();
			fill(vis, vis + n1, false);
			int f = 0;
			for (int u = 0; u < n1; ++u)
				if (!used[u] && dfs(u))
					++f;
			if (!f)
				return res;
			res += f;
		}
	}
};


int main()
{


    int N;
    while(cin>>N)
    {
        for ( int i = 0; i < N; i++ )
        {
            for ( int j = 0; j  < N; j++ )
            {
                rows[i][j] = -1;
                columns[i][j] = -1;
            }
        }
        for ( int i = 0; i < N; i++ )
        {
            scanf("%s",table[i]);
        }
        int r = -1;
        bool flag;
        for ( int i = 0; i < N; i++ )
        {
            flag = true;
            for( int j = 0; j <  N; j++ )
            {
                if ( table[i][j] == 'X' )
                {
                    flag =true;
                }
                else
                {
                    if ( flag )
                    {
                        r++;
                        flag = false;
                    }
                    rows[i][j] = r;
                }
            }
        }

        int c = -1;
        for ( int j = 0; j < N; j++ )
        {
            flag = true;
            for( int i = 0; i <  N; i++ )
            {
                if ( table[i][j] == 'X' )
                {
                    flag =true;
                }
                else
                {
                    if ( flag )
                    {
                        c++;
                        flag = false;
                    }
                    columns[i][j] = c;
                }
            }
        }

        hopcroftKarp::init(r+1, c+1);
        for( int i = 0; i < N; i++ )
        {
            for ( int j = 0; j < N; j++ )
            {
                if ( table[i][j] == '.')
                {
                    hopcroftKarp::addEdge(rows[i][j], columns[i][j]);
                }
            }
        }
        printInt(hopcroftKarp::maxMatching());
    }

    return 0;
}
