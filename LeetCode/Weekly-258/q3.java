class Solution {
    int ans=0;
    public int maxProduct(String s) {
        solve(0,s,"","");
        return ans;
    }
    public int LCS(String s1,String s2)
    {
        int n=s1.length(),m=s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++)
        dp[i][0]=0;
        for(int j=0;j<=m;j++)
        dp[0][j]=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                char ch1 = s1.charAt(i-1);
                char ch2 = s2.charAt(j-1);
                if(ch1 == ch2)
                dp[i][j]=dp[i-1][j-1]+1;
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
    public void solve(int i,String s,String f,String g)
    {
        if(i == s.length())
        {
            if(checkPalin(f)==true)
            {
                StringBuilder sb = new StringBuilder(g);
                ans = Math.max(ans,f.length()  * LCS(g,sb.reverse().toString()));
            }
            return ;
        }
        solve(i+1,s,f+s.charAt(i),g+"");
        solve(i+1,s,f+"",g+s.charAt(i));
    }
    public boolean checkPalin(String s)
    {
        int i=0,j=s.length()-1;
        while(i<=j)
        {
            if(s.charAt(i)!=s.charAt(j))
            return false;
            i++;j--;
        }
        return true;
    }
}
