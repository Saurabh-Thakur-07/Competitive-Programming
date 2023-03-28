class Solution {
    public int maxDistance(int[] position, int m) {
        int lo = 1,hi = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for(int val : position)
        {
            hi = Math.max(hi,val);
            set.add(val);
        }
        int ans = 1;
        while(lo <= hi)
        {
            int mid = lo + (hi - lo)/2;
            boolean val = isTrue(mid,set,m);
            // System.out.println(val+" "+mid);
            if(val==true)
            {
                ans = mid;
                lo = mid+1;
            }
            else
            {
                hi = mid-1;
            }
        }
        return ans;
    }
    public boolean isTrue(int k,TreeSet<Integer> set,int m)
    {
        int start = 0,count= 1;
        for(int val : set)
        {start = val;break;}
        // System.out.println(start);
        while(true)
        {
            if(set.higher(start+k-1)!=null)
            {
                start = set.higher(start+k-1);
                // System.out.println(start+" "+k);
                count++;
            }
            else
            break;
        }
        return count>=m;
    }
}
