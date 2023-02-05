class Solution {
    int n = 0;
    int[][] dp ;
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        n = floor.length();
        
        int[] prefix = new int[n];
        prefix[0]=floor.charAt(0)=='0'?0:1;
        
        dp = new int[floor.length()][numCarpets+1];
        for(int i=1;i<n;i++)
        {
            prefix[i] = prefix[i-1]+floor.charAt(i)-'0';
        }
        // print(prefix); 
        for(int[] a : dp)
        Arrays.fill(a,-1);
        
        for(int i=0;i<n;i++)
        {
            dp[i][0] = prefix[i];
        }
        for(int j=0;j<numCarpets;j++)
        dp[0][j]=0;
        int ans = solve(0,floor,numCarpets,carpetLen,prefix);
        return prefix[n-1]-ans;
    }
    public int solve(int idx,String floor,int noC,int cLen,int[] prefix)
    {
        if(idx >= n || noC == 0)
        {
            return 0;
        }
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;
        
        if(dp[idx][noC] != -1)
        {
            return dp[idx][noC];
        }
        
        if(floor.charAt(idx)=='1')
        {
            int high = Math.min(n-1,idx+cLen-1);
            int noOfCarpetCovered = prefix[high] - prefix[idx]+1;
            ans1 = noOfCarpetCovered + solve(high+1,floor,noC-1,cLen,prefix);
            ans2 = solve(idx+1,floor,noC,cLen,prefix);
            
            // System.out.println(idx+ " "+ans1+" "+ans2);
        }
        else
        {
            ans3 = solve(idx+1,floor,noC,cLen,prefix);
        }
        
        dp[idx][noC] = Math.max(Math.max(ans1,ans2),ans3);
        return dp[idx][noC];
    }
    public void print(int[] prefix)
    {
        for(int val : prefix)
            System.out.print(val+" ");
        System.out.println();
    }
}
