class Solution {
    public String reformatNumber(String number) {
       StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < number.length(); i ++) {
            if(number.charAt(i) != ' ' && number.charAt(i) != '-') {
                temp.append(number.charAt(i));
            }
        }
        int size = temp.length();
        for(int i = 0; i < size - 4; i += 3) {
            ans.append(temp.charAt(i));
            ans.append(temp.charAt(i + 1));
            ans.append(temp.charAt(i + 2));
            ans.append("-");
        }
        if(size % 3 == 1) {
            ans.append(temp.charAt(size - 4));
            ans.append(temp.charAt(size - 3));
            ans.append("-");
            ans.append(temp.charAt(size - 2));
            ans.append(temp.charAt(size - 1));
        }
        else if(size % 3 == 2) {
            ans.append(temp.charAt(size - 2));
            ans.append(temp.charAt(size - 1));
        }
        else if(size % 3 == 0) {
            ans.append(temp.charAt(size - 3));
            ans.append(temp.charAt(size - 2));
            ans.append(temp.charAt(size - 1));
        }
        return ans.toString(); 
    }
}
