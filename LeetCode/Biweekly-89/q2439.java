class Solution {
    public int minimizeArrayValue(int[] nums) {
         int l = 0, r =(int) 1e9;
        while (l < r) {
            int m = (l+r) >> 1;
            if (check(nums,m)) r = m;
            else l = m+1;
        }
        return l;
    }
//     public boolean check(int[] arr , int target)
//     {
//         long[] nums = new long[arr.length];
//         int n=nums.length;
//         for(int i=0;i<n;i++)
//             nums[i]=arr[i];
//         for(int i=0;i<n-1;i++)
//         {   
//             if(nums[i]>target)return false;
//             nums[i+1] -=(target-nums[i]);
//         }
//         if(nums[n-1]<=target)return true;
//         return false;
       
//     }
    public boolean check(int[] arr , int target)
    {
        long[] nums = new long[arr.length];
        int n=nums.length;
        for(int i=0;i<n;i++)
            nums[i]=arr[i];
        if(nums[0]>target)
        {
            return false;
        }
        long buff=target-nums[0];
        for(int i=1;i<n-1;i++)
        {
            nums[i]=nums[i]-buff;
            if(nums[i]>target)return false;
            buff=target-nums[i];
        }
        nums[n-1]-=buff;
        //  for(int val:nums)
        //     System.out.print(val+" ");
        // System.out.println();
        if(nums[n-1]<=target)return true;
        return false;
       
    }
}
