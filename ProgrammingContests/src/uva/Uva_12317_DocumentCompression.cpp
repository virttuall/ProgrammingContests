#include <bits/stdc++.h>

#define s(n) scanf("%d", &n);
#define forT(i, a, b) for( int i = a; i  <= b; i++ )

using namespace std;

int N, M, k, v, r, node, d, result;
const int maxV = 100000;
vector<int> init;
int dist[maxV];
queue<int> vDFS;
queue<int> vDist;

int main()
{
	while(true)
	{
		s(N); s(M);
		if ( N == 0 && M == 0) break;
		init = vector<int>();
		forT(i,1,N)
		{
			s(k);
			r = 0;
			forT(j,1,k)
			{
				s(v);
				r |= 1<<(v-1);
			}
			init.push_back(r);
		}
		fill_n(dist, maxV, -1);
		vDFS = queue<int>();
		vDist = queue<int>();
		vDFS.push(0);
		vDist.push(0);
		while( !vDFS.empty())
		{
			node = vDFS.front();
			d = vDist.front();
			vDFS.pop();
			vDist.pop();
			if (dist[node] != -1)
			{
				continue;
			}
			dist[node] = d;
			forT(i,0, init.size()-1)
			{
				vDFS.push(node | init[i]);
				vDist.push(d+1);
			}
		}
		forT(i, 1, M)
		{
			s(k);
			r = 0;
			forT(j,1,k)
			{
				s(v);
				r |= 1<<(v-1);
			}
			result = dist[r];
			if ( result == -1 )
			{
				result = 0;
			}
			if ( i == M)
			{
				printf("%d\n", result);
			}
			else
			{
				printf("%d ", result);
			}

		}
	}
	return 0;
}