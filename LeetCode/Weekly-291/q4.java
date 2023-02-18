class Solution {
    public long appealSum(String s) {
        HashMap<Character,LinkedList<Integer>> map = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            LinkedList<Integer> tlist = map.getOrDefault(ch,new LinkedList<Integer>());
            tlist.addLast(i);
            map.put(ch,tlist);
        }
        long[] dp = new long[n];
        long ans = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
            set.add(s.charAt(i));
            ans += set.size();
        }
        dp[0] = ans;
        LinkedList<Integer> list = map.get(s.charAt(0));
        if(list.size() == 1)
        map.remove(s.charAt(0));
        else 
        {
            list.removeFirst();
            map.put(s.charAt(0),list);    
        }
        for(int i = 1;i<n;i++)
        {
            list = map.get(s.charAt(i));
            if(list.size() == 1)
            map.remove(s.charAt(i));
            else 
            {
                list.removeFirst();
                map.put(s.charAt(i),list);    
            }
            
            if(s.charAt(i) == s.charAt(i-1))
            dp[i] = dp[i-1]-1;
            else
            {
                LinkedList<Integer> tlist = map.getOrDefault(s.charAt(i-1),new LinkedList<>());
                if(tlist.size()==0)
                {
                    dp[i]  = dp[i-1] - (n-i+1);
                }
                else
                {
                    dp[i] = dp[i-1] - (n-i+1) + (n-tlist.getFirst());
                }
            }
        }
        ans = 0;
        for(long a : dp)
        {
            // System.out.print(a+ " ");
            ans += a;}
        return ans;
    }
}
