import java.util.*;
public class q1
{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int i = 0 ; i < t ; i++){
            String str = scn.nextLine();
            str.toLowerCase();
            System.out.println(str);
            int n = str.length();
            if(n==3 && str.equals("yes"))
            {
                System.out.println("NO");
                return;
            }
            for(int j=0;j<n;j++)
            {
                char ch = str.charAt(j);
                if(j+1 < n)
                {
                    if(ch == 'y' && str.charAt(j+1) != 'e')
                    {
                        System.out.println("NO");
                        return;
                    }
                    if(ch == 'e' && str.charAt(j+1) != 's')
                    {
                        System.out.println("NO");
                        return;
                    }
                    if(ch == 's' && str.charAt(j+1) != 'y')
                    {
                        System.out.println("NO");
                        return;
                    }
                }
            }
            System.out.println("YES");
        }
    }
}
