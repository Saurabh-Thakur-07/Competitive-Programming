class Solution {
    public int halveArray(int[] nums) {
        double sum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : nums)
        {
            sum += val;
            double a = val;
            pq.add(a);
        }
        double half = sum/2;
        int ans = 0;
        while(sum > half)
        {
            double val = pq.remove();
            val = val/2.0;
            sum -= val ;
            pq.add(val);
            ans++;
        }
        return ans;
    }
}
