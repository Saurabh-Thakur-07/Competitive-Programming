class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> idx = new ArrayList<>();
        int n= nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==key)
            {
                idx.add(i);
                set.add(i);
            }
        }
        for(int idxs : idx)
        {
            int temp = k;
            for(int i=idxs-1;i>=0&&temp-->0;i--)
                set.add(i);
            temp = k;
            for(int i=idxs+1;i<n&&temp-->0;i++)
                set.add(i);
        }
        for(int val:set)
            ans.add(val);
        Collections.sort(ans);
        return ans;
    }
}
