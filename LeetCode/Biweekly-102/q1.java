class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int m=grid[0].length,n=grid.length;
        int[] ans = new int[m];
        for(int i=0;i<m;i++)
        {
            int max=0;
            for(int j=0;j<n;j++)
            {
                String s = Integer.toString(grid[j][i]);
                max=Math.max(max,s.length());
            }
            ans[i]=max;
        }
        return ans;
    }
}
