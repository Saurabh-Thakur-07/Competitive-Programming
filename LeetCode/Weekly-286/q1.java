class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums1)
            set.add(val);
        for(int val : nums2)
        {
            if(set.contains(val))
                set.remove(val);
        }
        for(int val : set)
            ans1.add(val);
        
        
        set = new HashSet<>();
        for(int val : nums2)
            set.add(val);
        for(int val: nums1)
        {
            if(set.contains(val)==true)
                set.remove(val);
        }
        for(int val : set)
            ans2.add(val);
        ans.add(ans1);
        ans.add(ans2);
        return ans;
    }
}
