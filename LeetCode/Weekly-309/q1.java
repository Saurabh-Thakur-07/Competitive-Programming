class Solution {
    public boolean checkDistances(String s, int[] distance) {
        Integer[][] alpha = new Integer[26][2];
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(alpha[ch-'a'][0]==null)
            alpha[ch-'a'][0]=i;
            else
            alpha[ch-'a'][1]=i;
        }
        for(int i=0;i<26;i++)
        {
            if(alpha[i][0]==null)
            continue;
            else
            {
                if(distance[i] != (alpha[i][1] - alpha[i][0]-1 ))
                return false;
            }
        }
        return true;
    }
}
