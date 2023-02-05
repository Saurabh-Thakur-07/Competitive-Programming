class Solution {
    int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        res = Integer.MAX_VALUE;
        int[] ans = new int[k];
        solve(jobs,0,ans);
        return res;
    }
    public void solve(int[] jobs,int idx,int[] ans)    
    {
        int max = getMax(ans);
        if(max >= res)
            return ;
        if(idx == jobs.length)
        {
            res=Math.min(res,max);
            return;
        }
        
        for(int i=0; i < ans.length;i++)
        {
            if(i>0 && ans[i]==ans[i-1])
            continue;
            ans[i] += jobs[idx];
            solve(jobs,idx+1,ans);
            ans[i] -= jobs[idx];
        }
    }
    public int getMax(int[] arr)
    {
        int max=Integer.MIN_VALUE;
        for(int val:arr)
            max=Math.max(val,max);
        return max;
    }
}
