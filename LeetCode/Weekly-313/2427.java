class Solution {
    public int commonFactors(int a, int b) {
        int ans=0,i=1;
        int minVal = Math.min(a,b);
        while(i<=minVal)
        {
            if(a%i==0&&b%i==0)
                ans++;
            i++;
        }
        return ans;        
    }
}
