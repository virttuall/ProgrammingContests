#include <bits/stdc++.h>

#define fora(i, s) for( int i = 0; i <  s; i++ )

using namespace std;

const int maxN = 300;
char barriers[maxN*maxN-1][maxN];
bool visited[2*maxN][2*maxN+1];
bool canV[4]; // up, right, down, left
int iis[4] = {-1, 0, 1, 0};
int jjs[4] = {0, 1, 0, -1};
int up1 = 0;
int right1 = 1;
int down1 = 2;
int left1 = 3;
int N;
int xb1, xb2, yb1, yb2, auxI, auxJ;
queue<int> qi;
queue<int> qj;
int result;

void coorBarrier( int i, int j)
{
	if ( i % 2 == 0)
	{
		if ( j % 2 == 0)
		{
			//(even, even)
			xb2 = i;
			yb2 = j/2;
			xb1 = xb2 -1;
			yb1 = yb2 -1;
		}
		else
		{
			//(even, odd)
			xb2 = i;
			yb2 = j / 2;
			xb1 = xb2 - 1;
			yb1 = yb2;
		}
	}
	else
	{
		if ( j % 2 == 0)
		{
			//(odd, even)
			xb2 = i;
			yb1 = j/2;
			xb1 = xb2 -1;
			yb2 = yb1 -1;
		}
		else
		{
			//(odd, odd)
			xb2 = i;
			yb2 = j/2;
			xb1 = xb2 - 1;
			yb1 = yb2;
		}
	}
}

bool validate(int i, int j)
{
	if ( i >= 0 && i < 2*N-1 && j >= 0 && j < N) return true;
	return false;
}

void can(int i, int j)
{
	canV[0] = canV[1] = canV[2] = canV[3] = true;
	if ( (i + j) % 2 == 0)
	{
		// *.
		// .*
		if ( validate(xb1, yb1))
		{

			if ( barriers[xb1][yb1] == 'H') canV[up1] = false;
			else canV[left1] = false;
		}
		if ( validate(xb2, yb2))
		{
			if ( barriers[xb2][yb2] == 'H') canV[down1] = false;
			else canV[right1] = false;
		}
	}
	else
	{
		// .*
		// *.
		if ( validate(xb1, yb1))
		{
			if ( barriers[xb1][yb1] == 'H') canV[up1] = false;
			else canV[right1] = false;
		}
		if ( validate(xb2, yb2))
		{
			if ( barriers[xb2][yb2] == 'H') canV[down1] = false;
			else canV[left1] = false;
		}
	}
	if ( i == 0 ) canV[up1] = false;
	if ( i == 2*N -1 ) canV[down1] = false;
	if ( j == 0) canV[left1] = false;
	if ( j == 2*N ) canV[right1] = false;
}
int main()
{
	while(cin>>N)
	{
		fora(i, 2*N-1)
		{
			scanf("%s", barriers[i]);
		}
		for( int i = 0; i < 2*N; i++ ) fill_n(visited[i], 2*N+1, false);
		result = 0;
		for( int i = 0; i < 2*N; i++ )
		{
			for( int j = 0; j < 2*N+1; j++ )
			{
				if ( !visited[i][j] )
				{
					qi = queue<int>();
					qj = queue<int>();
					qi.push(i);
					qj.push(j);
					result++;
					while( !qi.empty())
					{
						auxI = qi.front();
						qi.pop();
						auxJ = qj.front();
						qj.pop();
						if ( visited[auxI][auxJ]) continue;
						visited[auxI][auxJ] = true;
						coorBarrier(auxI, auxJ);
						can(auxI, auxJ);

						//printf("in %d,%d puede visitar up:%d ,right:%d, down:%d, left: %d with %d , %d --- %d , %d\n", auxI, auxJ,canV[0], canV[1], canV[2], canV[3], xb1,yb1, xb2, yb2);
						for(int k = 0; k < 4; k++ )
						{
							if ( canV[k] )
							{
								qi.push(auxI+iis[k]);
								qj.push(auxJ+jjs[k]);
							}
						}
					}
				}
			}
		}
		printf("%d\n", result-1);

	}
	return 0;
}