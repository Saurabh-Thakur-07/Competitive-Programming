class Solution {
    Long[][] dp;
    public int numberOfWays(int st, int en, int k) {
        dp = new Long[3002][1002];
        return (int)solve(st+1000,en+1000,k);
    }
    public long solve(int st,int en,int k)
    {
        if(st == en && k == 0)
        return 1;
        else if(k == 0)
        return 0;
        if(dp[st][k] != null)
        return dp[st][k];
        
        long forw = (solve(st+1,en,k-1))%1000000007;
        long back = (solve(st-1,en,k-1))%1000000007;
        long ans = (forw+back)%1000000007;
        dp[st][k] = ans;
        
        return ans;
    }
}
