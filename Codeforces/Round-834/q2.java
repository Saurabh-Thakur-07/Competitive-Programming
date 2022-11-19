import java.util.*;
public class q2
{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int i = 0 ; i < t ; i++){
            int n = scn.nextInt();
            int sum = scn.nextInt();
            int arr[] = new int[n];
            HashSet<Integer> set = new HashSet<Integer>();
            int start = 1,max=0;
            for(int j = 0 ; j < arr.length ; j++){
                arr[j] = scn.nextInt();
                set.add(arr[j]);
                max=Math.max(max,arr[j]);
            }
            while(sum > 0)
            {
                if(set.contains(start)==false)
                {
                    sum -= start;
                    set.add(start);
                }
                start++;
            }
            boolean flag = check1(set,max);
            if(sum == 0 && flag==true)
            {
                System.out.println("YES");
            }
            else
            {
                System.out.println("NO");
            }
        }
    }
    public static boolean check1(HashSet<Integer> set,int max)
    {
        int start = 1;
        while(start <= max)
        {
            if(set.contains(start)==false)
            return false;
            start++;
        }
        return true;
    }
}
