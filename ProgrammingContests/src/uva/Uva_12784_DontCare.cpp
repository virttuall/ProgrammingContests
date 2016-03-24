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
const int maxM = 30000;
vector<int> graph[maxN];
vector<int> graphInv[maxN];
queue<int> queueG;
int n, m, a, b, deep, auxNode;
bool visited[maxN], flag;


using namespace std;


// from http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
// my form don't worked :(
class Graph
{
    int V;    // No. of vertices
    list<int> *adj;    // Pointer to an array containing adjacency lists
    bool isCyclicUtil(int v, bool visited[], bool *rs);  // used by isCyclic()
public:
    Graph(int V);   // Constructor
    void addEdge(int v, int w);   // to add an edge to graph
    bool isCyclic();    // returns true if there is a cycle in this graph
};

Graph::Graph(int V)
{
    this->V = V;
    adj = new list<int>[V];
}

void Graph::addEdge(int v, int w)
{
    adj[v].push_back(w); // Add w to v’s list.
}

// This function is a variation of DFSUytil() in http://www.geeksforgeeks.org/archives/18212
bool Graph::isCyclicUtil(int v, bool visited[], bool *recStack)
{
    if(visited[v] == false)
    {
        // Mark the current node as visited and part of recursion stack
        visited[v] = true;
        recStack[v] = true;

        // Recur for all the vertices adjacent to this vertex
        list<int>::iterator i;
        for(i = adj[v].begin(); i != adj[v].end(); ++i)
        {
            if ( !visited[*i] && isCyclicUtil(*i, visited, recStack) )
                return true;
            else if (recStack[*i])
                return true;
        }

    }
    recStack[v] = false;  // remove the vertex from recursion stack
    return false;
}

// Returns true if the graph contains a cycle, else false.
// This function is a variation of DFS() in http://www.geeksforgeeks.org/archives/18212
bool Graph::isCyclic()
{
    // Mark all the vertices as not visited and not part of recursion
    // stack
    bool *visited = new bool[V];
    bool *recStack = new bool[V];
    for(int i = 0; i < V; i++)
    {
        visited[i] = false;
        recStack[i] = false;
    }

    // Call the recursive helper function to detect cycle in different
    // DFS trees
    for(int i = 0; i < V; i++)
        if (isCyclicUtil(i, visited, recStack))
            return true;

    return false;
}
int main()
{
    Graph g(0);
    while(true)
    {
        s(n); s(m);
        if ( n == 0 && m == 0) break;
        g = Graph(n);
        for ( int i = 0; i  < n; i++ )
        {
            graph[i] = vector<int>();
            graphInv[i] = vector<int>();
            visited[i] = false;
        }
        for ( int i = 0; i < m; i++ )
        {
            s(a); s(b);
            graph[a].push_back(b);
            graphInv[b].push_back(a);
            g.addEdge(a, b);
        }
        flag = !g.isCyclic();
        //if ( flag ) printInt(-1);
        for ( int i = 0; i  < n && flag; i++ )
        {
            if ( !visited[i] )
            {
                queueG = queue<int>();
                queueG.push(i);
                deep = -1;
                //printf("tamaño %d\n", queueG.size());
                while(!queueG.empty())
                {
                   // printf("hola");
                   auxNode = queueG.front();
                   queueG.pop();
                   //printf("auxNode %d", auxNode);
                   if ( graph[auxNode].size() == 0 )
                   {
                        //printInt(auxNode);
                        if ( deep == -1)
                        {
                            deep = auxNode;
                        }
                        else
                        {
                            if ( deep != auxNode )
                            {
                                flag = false;
                                break;
                            }
                        }
                   }
                   if ( !visited[auxNode] )
                   {
                        visited[auxNode] = true;
                        for ( int j = 0; j < graph[auxNode].size(); j++ )
                        {
                            queueG.push((graph[auxNode])[j]);
                        }
                   }
                }
            }
        }
        if ( flag )
        {
            printInt(1);
        }
        else
        {
            printInt(0);
        }

    }
    return 0;
}
