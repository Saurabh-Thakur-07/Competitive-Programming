import java.util.*;
public class b
{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int i = 0 ; i < t ; i++){
            int a=scn.nextInt();
            String str = scn.next();
            check(a,str);
        }
    }
    public static void check(int a,String str)
    {
        int n=str.length();
        long countz=0,counto=0;
        long ans=1;
        int k=0;
        for(int i=0;i<n;i++)
        {
            char ch=str.charAt(i);
            k=1;
            if(ch=='0')
            {
                while(i+1 < n && str.charAt(i+1)=='0')
                {
                    k++;i++;
                }
                countz += k;
            }
            else 
            {
                while(i+1 < n && str.charAt(i+1)=='1')
                {
                    k++;i++;
                }
                counto+=k;
            }
            ans=Math.max(ans,Math.max(counto*countz,k*k));
        }
        // ans=Math.max(ans,Math.max(counto*countz,k*k));
        System.out.println(ans);
    }
}
