class Solution {
    public List<Integer> factorize(int no)
    {
        List<Integer> res = new ArrayList<>();
        for(int i=2;i*i <= no;i++)
        {
            if(no % i ==0)
            {
                while(no%i == 0)
                no/=i;
                
                res.add(i);
            }
        }
        if(no > 1)
        res.add(no);
        
        return res;
    }
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> left = new HashMap<>();
        HashMap<Integer,Integer> right = new HashMap<>();
        
        for(int i=n-1;i>=0;i--)
        {
            for(int val : factorize(nums[i]))
            {
                right.put(val,right.getOrDefault(val,0)+1);
            }
        }
        int common = 0;
        for(int i=0;i<n-1;i++)
        {
            List<Integer> arr = factorize(nums[i]);
            for(int val : arr)
            {
                left.put(val,left.getOrDefault(val,0)+1);
                
                common += left.get(val) == 1 ? 1 : 0; // we apply line sweep algo to check factors if any factor has been added or not
                common -= left.get(val).equals(right.get(val)) ? 1 : 0; // factors getting nuetralzied
            }
            if(common == 0)
            return i;
        }
        return -1;
    }
}
