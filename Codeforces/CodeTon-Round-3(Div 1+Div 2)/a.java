import java.util.*;
public class a
{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int i = 0 ; i < t ; i++){
            int n = scn.nextInt();
            int arr[] = new int[n];
            for(int j = 0 ; j < arr.length ; j++){
                arr[j] = scn.nextInt();
            }
            if(arr[0]!=1)
            {
                System.out.println("NO");
            }
            else
            {
                check(arr);
            }
        }
    }
    public static void check(int[] arr)
    {

        int n=arr.length;
        int k=n;
        for(int i=n-1;i>=0;i--)
        {
            if(arr[i] != k)
            {
                int idxorig=-1,idxsmall=-1;
                int j=i;
                for(;j>=0;j--)
                {
                    if(arr[j]==k)
                    {
                        idxorig=j;
                        break;
                    }
                }
                if(j==0)
                {
                    System.out.println("NO");
                    return;
                }
                for(int m=idxorig-1 ; m >= 0 ; m--)
                {
                    if(arr[m] < arr[i])
                    {
                        idxsmall = m;
                        break;
                    }
                }
                if(idxsmall == -1)
                {
                    System.out.println("NO");
                    return;
                }
                swap(arr,i,idxorig);
            }
            k--;
        }
        System.out.println("YES");
    }
    public static void swap(int[] arr , int i , int j)
    {
        int t = arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}
