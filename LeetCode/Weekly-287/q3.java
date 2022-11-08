class Solution {
    public int maximumCandies(int[] candies, long k) {
        long sum=0;
        int max=Integer.MIN_VALUE;
        for(int val : candies)
        {
            sum+=val;
            max=Math.max(max,val);
        }
        if(sum < k)return 0;
        int lo = 1 , hi = max;
        int ans = 1 ;
        while(lo <= hi)
        {
            int mid = lo + (hi-lo)/2;
            System.out.println(mid);
            if(checkPossible(candies,mid,k)==false)
            {
                hi=mid-1;
            }
            else 
            {
                lo=mid+1;
                ans=Math.max(ans,mid);
            }
        }
        return ans;
    }
    public boolean checkPossible(int[] arr , int value , long k)
    {
        HashMap<Integer,Long> map = new HashMap<>();
        long a=0;
        for(int val : arr)
        {
            if(val >= value)
            {
                map.put(val%value,map.getOrDefault(val%value,a)+1);
                map.put(value,map.getOrDefault(value,a)+val/value);    
            }
            
        }
        long count = 0;
        for(Map.Entry<Integer,Long> hm : map.entrySet())
        {
            int key = hm.getKey();
            if(key >= value)
            {
                count += hm.getValue();
            }
        }
        if(count >= k)return true;
        return false;
    }
}
