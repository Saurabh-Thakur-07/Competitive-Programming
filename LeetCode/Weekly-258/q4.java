class Solution {
    public int[] smallestMissingValueSubtree(int[] par, int[] nums) {
        int n = par.length;
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        ArrayList<Integer> graph[] = new ArrayList[n];
        for(int i=0;i<n;i++)
        graph[i]=new ArrayList<>();
        for(int i=1;i<n;i++)
        graph[par[i]].add(i);
        
        int one=-1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==1)
            {
                one=i;
                break;
            }
        }
        if(one==-1)
        return ans;
        
        HashSet<Integer> subtr = new HashSet<>();
        int p=one;
        int miss=1;
        while(p>=0)
        {
            dfs(p,graph,subtr,nums);
            while(subtr.contains(miss)==true)
            miss++;
            ans[p]=miss;
            p=par[p];
        }
        return ans;
    }
    public void dfs(int node,ArrayList<Integer> graph[],HashSet<Integer> subtr,int[] nums)
    {
        if(subtr.contains(nums[node]))
        return;
        for(int nbr : graph[node])
        dfs(nbr,graph,subtr,nums);
        subtr.add(nums[node]);
    }
}
