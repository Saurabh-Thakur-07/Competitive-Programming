class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int ans = 0;
        System.out.println(nums.length);
        HashSet<String> set = new HashSet<>();
        for(int kk=0;kk<nums.length;kk++)
        {
            int i=kk;
            int div = 0;
            StringBuilder sb = new StringBuilder();
            while(i < nums.length)
            {
                sb.append(nums[i]+"#");
                String str = sb.toString();
                if(nums[i]%p == 0)
                {
                    div++;
                }
                
                if(div <= k)
                set.add(str);
                else 
                break;
                i++;
            }
            
        }
        return set.size();
    }
}
