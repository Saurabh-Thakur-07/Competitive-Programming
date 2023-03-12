class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Long,Long> map = new HashMap<>();
        map.put(0l,1l);
        long ans = 0 , nu = 0;
        for(int val : nums)
        {
            long a = val;
            nu = nu ^ a;
            long c = map.getOrDefault(nu,0l);
            ans += c;
            map.put(nu, c+1);
        }
        return ans;
    }
}
