class Solution {
    public boolean equalFrequency(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int val=-1;
        for(int j=0;j<s.length();j++)
        {
            map=new HashMap<>();
            val=-1;
            boolean flag =true;
            for(int i=0;i<s.length();i++)
            {
                if(j==i)
                    continue;
                char ch=s.charAt(i);
                if(map.containsKey(ch)==true)
                {
                    map.put(ch,map.get(ch)+1);
                }
                else
                {
                    map.put(ch,1);
                }
            }  
            for(Map.Entry<Character,Integer> set : map.entrySet())
            {
                val = set.getValue();
            }
            for(Map.Entry<Character,Integer> set : map.entrySet())
            {
                 int val1 = set.getValue();
                if(val!=val1)
                    flag=false;
            }
            if(flag==true)
            {
                return true;
            }
        }
        return false;
    }
}
