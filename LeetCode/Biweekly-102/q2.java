class Solution {
    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        ans[0]=2*nums[0];
        long max = nums[0];
        for(int i=1;i<n;i++)
        {
            max=Math.max(nums[i],max);
            long v = nums[i] + max;
            ans[i] = v + ans[i-1];
        }
        return ans;
    }
}
