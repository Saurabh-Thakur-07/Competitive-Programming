class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0,j=0;
        int ans = 0;
        while(j < nums.length)
        {
            if(nums[j] - nums[i] <= k)
                j++;
            else
            {
                i=j;
                ans++;
            }
        }
        return ans+1;
    }
}
