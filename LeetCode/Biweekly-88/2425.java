class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int val=0;
        int n= nums1.length,m=nums2.length;
        for(int i=0;i<n;i++)
        {
            if(m%2!=0)
            {
                val = val ^ nums1[i];
            }
        }
        for(int i=0;i<m;i++)
        {
            if(n%2!=0)
            {
                val = val ^ nums2[i];
            }
        }
        return val;
    }
}
