class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val : nums)
            map.put(val,map.getOrDefault(val,0)+1);
        int pairs = 0;
        for(int key : map.keySet())
        {
            int val = map.get(key);
            if(val%2!=0)
                return false;
        }
        return true;
    }
}
