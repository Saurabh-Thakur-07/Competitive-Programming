class Solution {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int ans = 0;
        ArrayList<Integer> sb = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int len = sb.size();
            if(len % 2 ==0)
            {
                while(i+1 < n && nums[i] == nums[i+1])
                {
                    ans++;
                    i++;
                }
                sb.add(nums[i]);
            }
            else
            {
                sb.add(nums[i]);
            }
        }
        if(sb.size()%2!=0)
        {
            ans++;
        }
        return ans;
    }
}
