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
#define printInt(n) printf("%d\n", n)


#define maX(a,b)    ( (a) > (b) ? (a) : (b))
#define miN(a,b)    ( (a) < (b) ? (a) : (b))


struct rQuery
{
    int suma;
    int mejorSuma;
    int sumaI;
    int sumD;
};

const int maxN = 1000000;
int start[2*maxN+100];
int finish[2*maxN+100];
int middle[2*maxN+100];
int bestSum[2*maxN+100];
int sum[2*maxN+100];
int leftSum[2*maxN+100];
int rightSum[2*maxN+100];
int arr[maxN+100];


void build(int node, int left, int right)
{
    start[node] = left;
    finish[node] = right;
    middle[node] = ( left + right)/2;
    if ( left == right )
    {
        sum[node] = arr[left-1];
        bestSum[node] = sum[node];
        leftSum[node] = sum[node];
        rightSum[node] = sum[node];
    }
    else
    {
        build(node*2, left, middle[node]);
        build(node*2+1, middle[node]+1, right);
        sum[node] = sum[node*2+1]+sum[node*2];
        leftSum[node] = maX(leftSum[2*node], sum[2*node]+leftSum[2*node+1]);
        rightSum[node] = maX(rightSum[2*node+1], sum[2*node+1]+rightSum[2*node]);
        bestSum[node] = maX( rightSum[2*node]+leftSum[2*node+1],maX(bestSum[node*2+1], bestSum[node*2]));
    }
}
rQuery query( int node, int left, int right)
{
    rQuery result;
    if ( start[node] == finish[node] )
    {
        result.mejorSuma = bestSum[node];
        result.suma = sum[node];
        result.sumaI = leftSum[node];
        result.sumD = rightSum[node];
        return result;
    }
    if ( left == start[node] && right == finish[node] )
    {
        result.mejorSuma = bestSum[node];
        result.suma = sum[node];
        result.sumaI = leftSum[node];
        result.sumD = rightSum[node];
        return result;
    }
    rQuery result1;
    rQuery result2;
    bool flag1 = false;
    bool flag2 = false;
    if ( left <= middle[node] )
    {
        result1 = query(node*2, left, miN(middle[node], right));
        flag1 = true;
    }
    if ( right >= middle[node] +1 )
    {
        result2 = query(node*2+1, maX(left, middle[node]+1), right);
        flag2 = true;
    }
    if ( !flag1) return result2;
    if ( !flag2) return result1;
    result.suma = result1.suma + result2.suma;
    result.sumaI = maX( result1.sumaI, result1.suma + result2.sumaI);
    result.sumD = maX( result2.sumD, result2.suma + result1.sumD);
    result.mejorSuma = maX( maX(result1.mejorSuma, result2.mejorSuma), result1.sumD+result2.sumaI);
    return result;
}
void print(int N)
{
    for ( int i = 1; i < 2*N; i++ )
    {
        printInt(start[i]);
        printInt(finish[i]);
        printInt(bestSum[i]);
        printf("\n");
    }
}

int main()
{
    int N, M, x ,y;
    s(N);
    for ( int i= 0; i < N; i++ )
    {
        scanf("%d", arr+i);
    }
    build(1, 1, N);
    s(M);
    for ( int i = 0; i < M; i++ )
    {
        s(x);
        s(y);
        printInt(query(1, x, y).mejorSuma);
    }
    return 0;
}
