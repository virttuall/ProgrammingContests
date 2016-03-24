
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


const int maxV = 100100;
vector<int> primesFactors[maxV];
int N, M, A[maxV], G, x, y;
vector<int> auxVector;
map<int, pair<int, int> >::iterator iterMap;
pair<int, int> auxPair;


struct segmentTree
{
    segmentTree *sonLeft;
    segmentTree *sonRight;
    int start, finish, middle;
    map<int, pair<int, int> > maps;
    segmentTree( int left, int right)
    {
        start = left;
        finish = right;
        middle = (left + right)/2;
        if ( left == right )
        {
            auxVector = primesFactors[A[left-1]];
            for ( int i = 0; i < auxVector.size(); i++ )
            {
                (maps)[auxVector[i]] = make_pair(A[left-1],1);
            }
            sonLeft = NULL;
            sonRight = NULL;
        }
        else
        {
            sonLeft = new segmentTree( left, middle);
            sonRight = new segmentTree( middle+1, right);
            for ( iterMap = sonLeft->maps.begin(); iterMap != sonLeft->maps.end(); ++iterMap )
            {
                (maps)[iterMap->first] = iterMap->second;
            }
            for ( iterMap = sonRight->maps.begin(); iterMap != sonRight->maps.end(); ++iterMap )
            {
                pair<int, int> &backs = (maps)[iterMap->first];
                if( backs.first < iterMap->second.first)
                {
                    backs = iterMap->second;
                }
                else if (backs.first == iterMap->second.first )
                {
                    backs.second += iterMap->second.second;
                }
            }

        }
    }


    pair<int, int> query( int left, int right)
    {
        //printf("query: %d %d %d %d\n", left, right, start, finish);
        pair<int, int> result = make_pair(-1, -1);
        if (  left == start && right == finish )
        {
            for ( int i = 0; i < auxVector.size(); i++ )
            {
                auxPair = (maps)[auxVector[i]];
                if ( auxPair.first )
                    if ( auxPair.first > result.first )
                        result = auxPair;
            }
            return result;
        }
        if ( middle +1 > right)
        {
            return sonLeft->query( left, right);
        }
        else if ( middle < left)
        {
            return sonRight->query( left, right);
        }
        result = sonLeft->query(left, middle);
        pair<int, int> result1 = sonRight->query( middle+1, right);
        if ( result.first > result1.first) return result;
        else if ( result1.first > result.first) return result1;
        else if ( result1.first == -1  ) return make_pair(-1, -1);
        else return make_pair(result.first, result.second+result1.second);
    }

};
void sieve()
{
    primesFactors[2].push_back(2);
    for ( int i= 4; i <= 100000; i+=2 )
    {
        primesFactors[i].push_back(2);
    }
    for ( int i = 3; i <= 100000; i+=2 )
    {
        if ( primesFactors[i].size() == 0 )
        {
            primesFactors[i].push_back(i);
            for ( int j = 2; j*i <= 100000; j++ )
            {
                primesFactors[i*j].push_back(i);
            }
        }
    }
}

int main()
{
    sieve();
    s(N); s(M);
    for ( int i = 0; i < N; i++ )
    {
        scanf("%d", A+i);
    }
    segmentTree st(1, N);


    //print();
    for ( int i= 0; i < M; i++ )
    {
        s(G);
        s(x);
        s(y);
        auxVector = primesFactors[G];
        auxPair = st.query( x, y);
        printf("%d %d\n", auxPair.first, auxPair.second);
    }
    return 0;
}
