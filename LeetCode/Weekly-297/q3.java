class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> idx = new HashMap<>();
        HashMap<Integer,Integer> ele = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            idx.put(i,nums[i]);
            ele.put(nums[i],i);
        }
        for(int[] op : operations)
        {
            int index = ele.get(op[0]);
            idx.remove(index);
            idx.put(index,op[1]);
            ele.remove(op[0]);
            ele.put(op[1],index);
        }
        for(int index : idx.keySet())
        {
            nums[index] = idx.get(index);
        }
        return nums;
    }
}
