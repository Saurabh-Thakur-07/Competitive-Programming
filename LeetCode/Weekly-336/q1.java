class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for(int i=left ; i <= right; i++)
        {
            String w = words[i];
            int len = w.length();
            char ch = w.charAt(0);
            if(ch == 'a' || ch =='e' || ch =='i' || ch=='o' || ch=='u')
            {
                ch = w.charAt(len-1);
                if(ch == 'a' || ch =='e' || ch =='i' || ch=='o' || ch=='u')
                ans++;
            }
        }
        return ans;
    }
}
