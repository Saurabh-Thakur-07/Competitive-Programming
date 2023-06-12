class Solution {
    public String reversePrefix(String word, char cha) {
        StringBuilder sb = new StringBuilder();
        String ans="";
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            sb.append(ch);
            if(ch == cha)
            {
                ans = ""+sb.reverse().toString()+word.substring(i+1);
                break;
            }
        }
        if(ans.length()==0&&word.length()>0)
        ans=""+sb.toString();
        return ans;
    }
}
