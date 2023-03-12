class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long ans = 0;
        int c=0;
        for(int i=nums.length-1;i>=0;i--)
        {
            int val = nums[i];
            if(val > 0)
            {
                ans += val;
                c++;
            }
            else if(val <= 0 && ans + val > 0)
            {
                ans += val;
                c++;
            }
        }
        return c;
    }
}
