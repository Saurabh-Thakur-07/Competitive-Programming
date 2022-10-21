import java.util.* ;
import java.io.*; 
public class Solution {
    static int maximumWins(int []a) {
        int n=2*a.length;
        TreeSet<Integer> tset = new TreeSet<>();
        HashSet<Integer> set = new HashSet<>();
        for(int val:a)
        {
            set.add(val);
        }
        for(int i=1;i<=n;i++)
        {
            if(set.contains(i)==false)
                tset.add(i);
        }
        int ans=0;
        for(int val:a)
        {
            if(tset.higher(val)!= null)
            {
                int val1 = tset.higher(val);
                tset.remove(val1);
                ans++;
            }
        }
        return ans;
    }
}
