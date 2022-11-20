class Solution {
    static long ans=0;
    public long dfs(int root ,ArrayList<Integer> graph[] , boolean[] visited,int seats)
    {
        visited[root]=true;
        long count = 1;
        for(int val : graph[root])
        {
            if(visited[val]==false)
            {
                count += dfs(val,graph,visited,seats);
            }
        }
        long carsReq = count/seats;
        if(count%seats != 0)carsReq++;
        if(root != 0)ans+= carsReq;
        return count;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        ans=0;
        int n=roads.length;
        if(n==0)return 0;
        ArrayList<Integer> graph[] = new ArrayList[n+1];
        for(int i=0;i<n+1;i++)
            graph[i]=new ArrayList<Integer>();
        for(int[] a : roads)
        {
            int val1 = a[0],val2=a[1];
            graph[val1].add(val2);
            graph[val2].add(val1);
        }
        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited,false);
        dfs(0,graph,visited,seats);
        return ans;
    }
}
