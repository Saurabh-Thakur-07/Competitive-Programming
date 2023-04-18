class pair implements Comparable<pair>
{
    int dest;
    int cost;
    public pair(int dest,int cost)
    {
        this.dest=dest;
        this.cost=cost;
    }
    public int compareTo(pair o)
    {
        return this.cost - o.cost;
    }
}
class Graph {
    ArrayList<pair> graph[];
    boolean[] vis;
    public Graph(int n, int[][] edges) {
        vis = new boolean[n];
        graph = new ArrayList[n];
        for(int i=0;i<n;i++)
        graph[i] = new ArrayList<>();
        
        for(int[] e : edges)
        {
            int s= e[0],d=e[1],c=e[2];
            graph[s].add(new pair(d,c));
        }
    }
    
    public void addEdge(int[] e) {
        int s= e[0],d=e[1],c=e[2];
        graph[s].add(new pair(d,c));
    }
    
    public int shortestPath(int node1, int node2) {
        int ans = Integer.MAX_VALUE;
        Arrays.fill(vis,false);
        return dijkstra(node1,node2,0);
    }
    public int dijkstra(int node1,int node2,int tc)
    {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(node1,0));
        
        while(pq.size()>0)
        {
            int sz = pq.size();
            while(sz-->0)
            {
                pair rem = pq.remove();
                vis[rem.dest]=true;
                if(rem.dest == node2)
                return rem.cost;
                for(pair nbr : graph[rem.dest])
                {
                    if(vis[nbr.dest]==false)
                    {
                        pq.add(new pair(nbr.dest,rem.cost+nbr.cost));
                    }
                }
            }
        }
        return -1;
    }
}

/**
 * Your Garaph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
