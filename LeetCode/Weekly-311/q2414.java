class Solution {
    public int longestContinuousSubstring(String s) {
        if(s.length()==1)
            return 1;
        int ans=0;
        int len=1,n=s.length(),prev=s.charAt(0);
        for(int i=1;i<n;i++)
        {
            char ch=s.charAt(i);
            if((int)ch == (int)(prev+1))
            {
                prev=ch;
                len++;
            }
            else
            {
                prev=ch;
                len=1;
            }
            ans=Math.max(len,ans);
        }
        return ans;
    }
}
