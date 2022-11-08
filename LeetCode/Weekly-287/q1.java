class Solution {
    public int convertTime(String current, String correct) {
        int val1 = Integer.parseInt(correct.substring(0,2))*60 + Integer.parseInt(correct.substring(3,5));
        int val2 = Integer.parseInt(current.substring(0,2))*60 + Integer.parseInt(current.substring(3,5));
        System.out.println(val1+" "+val2);
        int time = val1-val2;
        int t60 = (val1-val2)/60;
        int t15 = ((val1-val2)%60)/15;
        int t5 = (((val1-val2)%60)%15)/5;
        int t1 = (((val1-val2)%60)%15)%5;
        return t60+t15+t5+t1;
    }
}
