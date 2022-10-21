import java.util.*;
public class Solution {
    static int maximumCollected(int n, int dist, int []a) {
        int ans=0;
         PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++)
        {
            if(a[i]==1)
                pq.add(i);
        }
        for(int i=0;i<n;i++)
        {
            if(a[i]==0)
            {
                int uprange = i+dist>=n?n-1:i+dist;
                int lorange = i-dist<0?0:i-dist;
                while(!pq.isEmpty()&& pq.peek() < lorange)
                {
                    pq.remove();
                }
                if(pq.size()>0&&pq.peek()>=lorange && pq.peek() <=uprange)
                {pq.remove();ans++;}
            }
        }
        return ans;
    }
}
