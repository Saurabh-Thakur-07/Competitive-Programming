class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        Integer[][] dp = new Integer[n+1][k+1];
        
        return solve(0,piles,k,dp);
    }
    public int solve(int idx,List<List<Integer>> piles,int k,Integer[][] dp)
    {
        if(idx == piles.size() || k == 0)
            return 0;
        if(dp[idx][k] != null)
            return dp[idx][k];
        
        int max = solve(idx+1,piles,k,dp);
        
        int currSum = 0;
        for(int i=0;i<Math.min(piles.get(idx).size(),k);i++)
        {
            currSum += piles.get(idx).get(i);
            
            max = Math.max(max,currSum + solve(idx+1,piles,k-i-1,dp));
        }
        dp[idx][k] = max;
        return max;
    }
}
