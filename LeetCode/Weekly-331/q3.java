class Solution {
    public boolean isPossible(int[] nums,int n,int k,int val)
    {
        for(int i=0;i<n;i++)
        {
            if(nums[i] <= val)
            {
                i++;
                k--;
            }
            if(k==0)
                break;
        }
        if(k==0)
            return true;
        return false;
    }
    public int minCapability(int[] nums, int k) {
        int mine = Integer.MAX_VALUE;
        int maxe = Integer.MIN_VALUE;
        
        for(int val : nums)
        {
            mine = Math.min(val,mine);
            maxe = Math.max(val,maxe);
        }
        
        int l = mine; 
        int r = maxe;
        int ans = Integer.MAX_VALUE;
        
        while(l <= r)
        {
            int mid = l + (r-l)/2;
            
            if(isPossible(nums,nums.length,k,mid)==true)
            {
                r = mid-1;
                ans = Math.min(ans,mid);
            }
            else
                l=mid+1;
        }
        return ans;
    }
}
