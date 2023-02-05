class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : gifts)
            pq.add(val);
        
        long ans = 0;
        while(k-->0)
        {
            int val = pq.remove();
            pq.add((int)Math.sqrt(val));
        }
        while(pq.size()>0)
            ans += pq.remove();
        return ans;
    }
}
