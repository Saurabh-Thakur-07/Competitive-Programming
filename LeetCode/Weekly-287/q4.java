class Encrypter {
    HashMap<Character,String> dict ;
    HashMap<String,Integer> map;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        dict = new HashMap<>();
        map = new HashMap<>();
        for(int i=0;i<keys.length;i++)
        {
            dict.put(keys[i],values[i]);
        }
        for(String str : dictionary)
        {
            String ans = encrypt(str);
            map.put(ans,map.getOrDefault(ans,0)+1);
        }
    }
    
    public String encrypt(String word1) {
        String str = "";
        int n=word1.length();
        for(int i=0;i<n;i++)
        {
            char ch = word1.charAt(i);
            if(dict.containsKey(ch)==true)
            {
                str += dict.get(ch);
            }
            else
            {
                return "";
            }
        }
        return str;
    }
    
    public int decrypt(String word2) {
        return map.getOrDefault(word2,0);
    }
}
/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */
