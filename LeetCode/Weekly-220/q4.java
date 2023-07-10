class Solution {
    int[] par;
    int[] rank;
    public int find(int node)
    {
        if(par[node]==node)
        return node;
        par[node] = find(par[node]);
        return par[node];
    }
    public void merge(int n1,int n2)
    {
        int par1 = find(n1);
        int par2 = find(n2);
        if(rank[par1] > rank[par2])
        {
            par[par2]=par1;
            
        }
        else if(rank[par1] < rank[par2])
        {
            par[par1]=par2;
        }
        else
        {
            rank[par1]++;
            par[par2]=par1;
        }
    }
    public boolean isConnected(int n1,int n2)
    {
        int par1 = find(n1);
        int par2 = find(n2);
        return par1 == par2;
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edg, int[][] qu) {
        Arrays.sort(edg,(e1,e2)->(e1[2]-e2[2]));
        int ql = qu.length,m=edg.length;
        int[][] que = new int[ql][4];
        for(int i=0;i<ql;i++)
        {
            que[i][0]=qu[i][0];
            que[i][1]=qu[i][1];
            que[i][2]=qu[i][2];
            que[i][3]=i;
        }
        Arrays.sort(que,(q1,q2)->(q1[2]-q2[2]));
        par = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++)
        {
            par[i]=i;
            rank[i]=1;
        }
        boolean[] ans = new boolean[ql];
        int i=0;
        for(int[] q : que)
        {
            while(i<m && edg[i][2] < q[2])
            {
                merge(edg[i][0],edg[i][1]);
                i++;
            }
            ans[q[3]]= isConnected(q[0],q[1]);
        }
        return ans;
    }
}