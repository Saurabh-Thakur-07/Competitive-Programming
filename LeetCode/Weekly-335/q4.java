class Solution {
    int mod = 1000000007;
    public int waysToReachTarget(int t, int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        Long[][] dp = new Long[n+1][t+1];
        return (int)solve(0,t,arr,dp);
    }
    public long solve(int idx,int sum,int[][] arr,Long[][] dp)
    {
        if(sum < 0)
        return 0;
        if(sum == 0)
        return 1;
        if(idx >= arr.length)
        return 0;
        if(dp[idx][sum] != null)
        return dp[idx][sum];
        long ans = 0;
        int count = arr[idx][0];
        int val = arr[idx][1];
        ans += solve(idx+1,sum,arr,dp);
        for(int i=1;i<=count;i++)
        {
            int aval = i*val;
            long tans = solve(idx+1,sum-aval,arr,dp);
            ans = (ans + tans)%mod;
        }
        dp[idx][sum] = ans%mod;
        return ans%mod;
    }
}
