public class Solution {
    static int asciiSubstrings(String s) {
        int sum=0,ans=0;
        for(int i=0;i<3;i++)
        {
            sum += (int)s.charAt(i);
        }
        if(sum%3==0)ans++;
        for(int i=3;i<s.length();i++)
        {
            sum += (int)s.charAt(i) - (int)s.charAt(i-3);
            if(sum%3==0)ans++;
        }
        return ans;
    } 
}
