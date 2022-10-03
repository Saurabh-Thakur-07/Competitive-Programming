class Solution {
    public int minimizeXor(int m, int n) {
        int count=0;
        int t=n;
        while(n>0)
        {
            int rsbm=n&(-n);
            n-=rsbm;
            count++;
        }
        int fres=0;
        for(int i=31 ; i>=0;i--)
        {
            if((m&(1<<i))>0 && count>0)
            {
                fres |= (1<<i);
                count--;
            }
        }
        for(int i=0;i<=31&&count>0;i++)
        {
            if((fres & 1<<i)==0)
            {
                fres |= (1<<i);
                count--;
            }
            
        }
        return fres;
    }
}
