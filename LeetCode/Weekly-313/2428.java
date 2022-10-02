class Solution {
    public int maxSum(int[][] grid) {
        int ans=Integer.MIN_VALUE;
        int m=grid.length,n=grid[0].length;
        int rc = m-3+1;
        
        int cc = n-3+1;
        for(int i=0;i<rc;i++)
        {
            for(int j=0;j<cc;j++)
            {
                int max = func(grid,i,j);
                System.out.println(max);
                ans=Math.max(ans,max);
            }
        }
        return ans;
    }
    public int func(int[][] grid, int sti , int stj)
    {
        int ans=0;
        for(int i=sti,j=stj;j<(stj+3);j++)
        {
            ans += grid[i][j];
        }
        ans += grid[sti+1][stj+1];
        for(int i=sti+2,j=stj;j<(stj+3);j++)
        {
            ans+=grid[i][j];
        }
        return ans;
    }
}
