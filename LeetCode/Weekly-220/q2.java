class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int ans=0;
        HashSet<Integer> set = new HashSet<>();
        int i=0,j=0,n=nums.length;
        int sum=0;
        while(j<n)
        {
            if(set.contains(nums[j])==true)
            {
                while(i<j && set.contains(nums[j])==true)
                {
                    sum -= nums[i];
                    set.remove(nums[i++]);
                }
            }
            set.add(nums[j]);
            sum += nums[j++];
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}