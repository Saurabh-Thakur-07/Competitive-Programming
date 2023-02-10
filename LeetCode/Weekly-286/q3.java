class Solution {
    public long[] kthPalindrome(int[] que, int len) {
        StringBuilder max = new StringBuilder();
        for(int i=0;i<len;i++)
            max.append("9");
        
        if(len <= 2)
        {
            long ans[] = new long[que.length];
            for(int i=0;i<que.length;i++)
            {
                if(que[i] > 9)
                    ans[i]=-1;
                else
                {
                    if(len == 1)
                        ans[i]=que[i];
                    else
                        ans[i]=que[i]*10+que[i];
                }
            }
            return ans;
        }
        long maxV = Long.parseLong(max.toString());
        long maxPos = 1;
        long t = len;
        if(t % 2 == 0)
            t--;
        while(t > 1)
        {
            t -=2;
            maxPos *= 10;
        }
        if(t == 1)
            maxPos *= 9;
        
        long ans[] = new long[que.length];
        for(int i=0;i<que.length;i++)
        {
            if(que[i] > maxPos)
                ans[i]=-1;
            else if(que[i]==maxPos)
                ans[i]=maxV;
            else
                ans[i]=solve(que[i],maxPos,len);
        }
        return ans;
    }
    public long solve(long val , long max , int len)
    {
        val--;
        StringBuilder mask = new StringBuilder(Long.toString(max));
        StringBuilder sb1 = new StringBuilder(Long.toString(val));
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        if(sb1.length() < mask.length())
        {
            int diff = mask.length()-sb1.length();
            for(int i=0;i<diff;i++)
                sb.append('0');
            for(int i=0;i<sb1.length();i++)            
                sb.append(sb1.charAt(i));
        }
        else if(sb1.length()==mask.length())
            sb=sb1;
        
        for(int i=0;i<sb.length();i++)
        {
            char ch = sb.charAt(i);
            if(i==0)
            {
                int v = 1+ch-'0';
                // System.out.println(v);
                ans.append(v);
            }  
//             else if(i==sb.length()-1)
//             {
//                 if(ch == '0')
//                 {
//                     ans.append(9);
//                 }
//                 else
//                 {
//                     int v = ch-'0'-1;
//                     ans.append(v);
//                 }
                
//             }   
            else
            {
                int v = ch-'0';
                ans.append(v);
            }     
        }
        if((len-2)%2==0)
        {
            for(int i=ans.length()-1;i>=0;i--)
                ans.append(ans.charAt(i));
        }
        else
        {
            for(int i=ans.length()-2;i>=0;i--)
                ans.append(ans.charAt(i));
        }
        // System.out.println(ans+" "+val);
        return Long.parseLong(ans.toString());
    }
}
