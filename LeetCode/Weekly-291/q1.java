class Solution {
    public String removeDigit(String number, char digit) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < number.length() ; i++){
            if(number.charAt(i)==digit){
                list.add(i);
            }
        }
        
        String res="-9999999" ;
        for(int i = 0 ; i < list.size() ; i++){
            String part1 = number.substring(0,list.get(i));
            String part2 = number.substring(list.get(i)+1,number.length());
            String ans = part1+part2;
            if((ans.compareTo(res))>0){
                res = ans;
            }
        }
        return res;
    }
}
