class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double,Long> map = new HashMap<>();
        for(int[] r : rectangles)
        {
            double wh = ((double)r[0]/(double)r[1]);
            map.put(wh,map.getOrDefault(wh,0l)+1);
        }
        long ans=0;
        for(double key : map.keySet())
        {
            // System.out.println(key+" ");
            long val = map.get(key);
            ans += (val*(val-1))/2;
        }
        return ans;
    }
}
