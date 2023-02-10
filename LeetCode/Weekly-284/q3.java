class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        int max = nums[0];
        if(n == 1 && k %2 == 1)
            return -1;
        else if(n==1 && k%2 == 0)
            return nums[0];
        if(k == 1)
            return nums[k];
        int sz = Math.min(nums.length,k-1);
        for(int i=0;i <sz;i++)
        {
            max = Math.max(nums[i],max);
        }
        if(k < nums.length)
            max = Math.max(nums[k],max);
        return max ;
    }
}
