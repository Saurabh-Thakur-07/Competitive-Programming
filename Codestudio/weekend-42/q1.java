public class Solution {
    static int[] largestConfiguration(int n, int z, int []a) {
        int[] ans = new int[n-z];
        int maxval=0,maxidx=0;
        for(int i=0;i<=z;i++)
        {
            if(a[i]>maxval)
            {
                maxval=a[i];
                maxidx=i;
            }
        }
        int k=0;
        while(k<ans.length)
        {
            ans[k++]=a[maxidx++];
        }
        return ans;
    }
}
