class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int t=n;
        int mod=1000000007;
        ArrayList<Integer> li = new ArrayList<>();
        while(n!=0)
        {

            int result = ((int)(Math.log(n) / Math.log(2)))%mod;    
            int val=((int)Math.pow(2,result))%mod;
            li.add(result);
            n=(n-val)%mod;
        }    
        int[] arr = new int[li.size()];
        int m=queries.length;
        int[] ans = new int[m];
        Collections.sort(li);
        for(int i=0;i<li.size();i++)
            arr[i]=(li.get(i))%mod;
        for(int i=1;i<arr.length;i++)
        {
            arr[i]=((arr[i])%mod+(arr[i-1])%mod)%mod;
        }
        for(int i=0;i<m;i++)
        {
            int val1=queries[i][0];
            int val2=queries[i][1];
            if(val1==0)
            {
                int val=((int)arr[val2])%mod;
                int k=0,a=1;
                while(k<val)
                {
                    a=(a*2)%mod;
                    k++;
                }
                ans[i]=a%mod;
            }
                
            else 
            {
                int val=((int)arr[val2]-arr[val1-1])%mod;
                int k=0,a=1;
                while(k<val)
                {
                    a=(a*2)%mod;
                    k++;
                }
                ans[i]=a%mod;
            }
                
        }
        return ans;
    }
}
