class Solution {
    public boolean calcVowel(String str)
    {
        char ch1 = str.charAt(0);
        char ch2 = str.charAt(str.length()-1);
        if(ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 =='u')
        {
            ch1 = ch2;
            if(ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 =='u')
            {
                return true;
            }
            return false;
        }
        return false;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n];
        Arrays.fill(prefix,0);
        for(int i=0;i<words.length;i++)
        {
            boolean val = calcVowel(words[i]);
            prefix[i] = val == true ? 1 : 0;
            if(i-1>=0)
            {
                prefix[i]+=prefix[i-1];
            }
        }
        int[] ans = new int[queries.length];
        int i=0;
        for(int[] a : queries)
        {
            if(a[0]==0)
                ans[i++]=prefix[a[1]];
            else
                ans[i++]=prefix[a[1]]-prefix[a[0]-1];
        }
        return ans;
    }
}
