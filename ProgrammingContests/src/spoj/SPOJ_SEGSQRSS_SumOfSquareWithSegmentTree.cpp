//virtuall

#include <cstdio>
#include <numeric>
#include <iostream>
#include <vector>
#include <set>
#include <cstring>
#include <string>
#include <map>
#include <cmath>
#include <ctime>
#include <algorithm>
#include <bitset>
#include <queue>
#include <sstream>
#include <deque>


// input macros
#define s(n)    scanf("%d",&n)
#define sc(n)   scanf("%c",&n)
#define sl(n)   scanf("%lld",&n)
#define sf(n)   scanf("%lf",&n)
#define ss(n)   scanf("%s",n)
#define printInt(n) printf("%d", n)


#define maX(a,b)    ( (a) > (b) ? (a) : (b))
#define miN(a,b)    ( (a) < (b) ? (a) : (b))




const int maxN = 1000000;
int start[2*maxN+100];
int finish[2*maxN+100];
int middle[2*maxN+100];
long long value[2*maxN+100];
int arr[maxN+100];

void build(int node, int left, int right)
{
    start[node] = left;
    finish[node] = right;
    middle[node] = ( left + right)/2;
    if ( left == right )
    {
        value[node] = ((long long)(arr[left-1]));
        value[node] *= value[node];
    }
    else
    {
        build(node*2, left, middle[node]);
        build(node*2+1, middle[node]+1, right);
        value[node] = value[node*2]+value[node*2+1];
    }
}
long long query( int node, int left, int right)
{
    if ( start[node] == finish[node] )
    {
        return value[node];
    }
    if ( left == start[node] && right == finish[node] )
    {
        return value[node];
    }
    long long result = 0l;
    if ( left <= middle[node] )
    {
        result += query(node*2, left, miN(middle[node], right));
    }
    if ( right >= middle[node] +1 )
    {
        result += query(node*2+1, maX(left, middle[node]+1), right);
    }
    return result;
}
long long setV(int node, int left, int right, int v)
{
    long long change;
    if ( start[node] == finish[node] )
    {
        arr[start[node]-1] = v;
        change = value[node];
        value[node] = (long long)(v);
        value[node] *= value[node];
        return -change + value[node];
    }
    change = 0l;
    if ( left <= middle[node])
    {
        change += setV(node*2, left, miN(middle[node], right), v );
    }
    if ( right >= middle[node] +1 )
    {
        change += setV(node*2+1, maX(middle[node]+1 , left),right, v );
    }
    value[node] += change;
    return change;
}
long long add( int node, int left, int right, int v)
{
    long long change;
    if ( start[node] == finish[node])
    {
        arr[start[node]-1] += v;
        change = value[node];
        value[node] = (long long)(arr[left-1]);
        value[node] *= value[node];
        return -change + value[node];
    }
    change = 0l;
    if ( left <= middle[node] )
    {
        change += add(node*2, left, miN(middle[node], right), v);
    }
    if ( right >= middle[node]+1)
    {
        change += add(node*2+1, maX(middle[node]+1, left), right, v);
    }
    value[node] += change;
    return change;
}
void print(int N)
{
    printf("print");
    for ( int i = 1; i < 2*N; i++ )
    {
        printf("value : %d\n", value[i]);
    }
    printf("\n\n");
}
int main()
{
    int nCases, N, Q, cm, st, nd, val;
    s(nCases);
    for ( int nC = 0; nC < nCases; nC++ )
    {
        s(N);
        s(Q);
        for ( int i = 0; i < N; i++ )
        {
            scanf("%d", arr + i);
        }
        build(1, 1, N);
        printf("Case %d:\n", nC+1);
        for ( int i = 0; i < Q; i++ )
        {
            s(cm);
            s(st);
            s(nd);
            if ( cm == 0)
            {
                s(val);
                setV(1, st, nd, val);
            }
            else if ( cm == 1)
            {
                s(val);
                add(1, st, nd, val);
            }
            else
            {

                printf("%d\n", query(1, st, nd));
            }
        }


    }
    return 0;
}
