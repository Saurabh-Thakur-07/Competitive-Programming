class Solution {
    public int longestNiceSubarray(int[] nums) {
        int AND = 0,i=0,j=0,ans=0;
        for(;j<nums.length;j++)
        {
            while((AND&(nums[j]))>0)
            AND ^= nums[i++];
            
            AND |= nums[j];
            ans = Math.max(ans,(j-i+1));
        }
        return ans;
    }
}
