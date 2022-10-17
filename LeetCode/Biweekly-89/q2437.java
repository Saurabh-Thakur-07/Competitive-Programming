class Solution {
    public int countTime(String time) {
        int total=1;
        char ch1=time.charAt(0);
        char ch2=time.charAt(1);
        char ch3=time.charAt(3);
        char ch4=time.charAt(4);
        if(ch1=='?' && ch2=='?')
            total*=24;
        else if(ch1=='?' && ch2!='?')
        {
            if(ch2-'0'<=3)
                total *=3;
            else
                total *=2;
        }
        if(ch1 != '?' && ch2=='?')
        {
            if(ch1-'0'<=1)
                total*=10;
            else 
                total*=4;
        }        
        if(ch3=='?' && ch4=='?')
            total*=60;
        else if(ch3=='?' && ch4!='?')
            total *=6;
        if(ch3 != '?' && ch4=='?')
            total*=10;
        return total;
    }
}
