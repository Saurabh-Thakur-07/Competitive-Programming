class Solution {
    public int longestSubarray(int[] nums) {
        int prev=nums[0],max=1,ans=1,val=prev;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==prev)
            {
                max++;
                if(prev == val)
                {
                    val=prev;
                    ans=Math.max(max,ans);
                }
            }
            else
            {
                prev=nums[i];
                max=1;
                if(prev > val)
                {
                    val=prev;
                    ans=max;
                }
            }
            
        }
        return ans;
    }
}
