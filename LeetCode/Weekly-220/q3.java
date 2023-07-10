class Solution {
    class pair implements Comparable<pair>
    {
        int idx,val;
        public pair(int idx,int val)
        {
            this.idx=idx;
            this.val=val;
        }
        public int compareTo(pair o)
        {
            if(this.val == o.val)
            return o.idx - this.idx;
            return o.val - this.val;
        }
    }
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        PriorityQueue<pair> pq = new PriorityQueue<>();
        pq.add(new pair(n-1,nums[n-1]));
        dp[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            while(pq.size()>0 && pq.peek().idx>i+k)
            pq.remove();
            
            dp[i] = nums[i];
            if(pq.size()>0)
            dp[i]+=pq.peek().val;
            
            pq.add(new pair(i,dp[i]));
        }
        return dp[0];
    }
}