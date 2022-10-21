    import java.util.* ;
    import java.io.*; 
    public class Solution {

        static int guessingChairs(int n, int k, int []a, int []b) {
            int[][] arr = new int[n][2];
            for(int i=0;i<n;i++)
            {
                arr[i][0]=a[i];arr[i][1]=b[i];
            }
            Arrays.sort(arr,new Comparator<int[]>(){
                public int compare(int[] a1,int[] a2)
                {
                    if(a1[0]>a2[0])return 1;
                    else if(a1[0]==a2[0])
                    {
                        if(a1[1]>a2[1])return 1;
                        else return -1;
                    }
                    else return -1;
                }
            });
            PriorityQueue<Integer> pq = new PriorityQueue<>();
    //         for(int i=0;i<n;i++)
    //         {
    //             System.out.print(arr[i][0]+" ");
    //         }
    //         System.out.println();
    //         for(int i=0;i<n;i++)
    //         {
    //             System.out.print(arr[i][1]+" ");
    //         }
            pq.add(arr[0][1]);
            int max=1;
            for(int i=1;i<n;i++)
            {
                int val=pq.peek();
                while(pq.size()>0&&arr[i][0]>pq.peek())
                {
                    pq.remove();
                }
                pq.add(arr[i][1]);
                max=Math.max(max,pq.size());
            }
            return k*max;
        }
    }
