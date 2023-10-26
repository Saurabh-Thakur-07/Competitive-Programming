import java.io.*;
import java.util.*;

public class C {
	static class pair implements Comparable<pair>
	{
		int l,r,i;
		public pair(int l,int r,int i)
		{
			this.l=l;
			this.r=r;
			this.i=i;
		}
		public int compareTo(pair o)
		{
			if(this.r == o.r)
			return this.l-o.l;
			return this.r-o.r;
		}
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner scn = new Scanner(System.in);
		int te = scn.nextInt();
		// System.out.println(t);
		while(te-->0)
		{
			int n = scn.nextInt();
			int[] suf = new int[n];
			pair[] arr = new pair[n];
			boolean flag=false;
			for(int i=0;i<n;i++)
			{
				int l = scn.nextInt();
				int r = scn.nextInt();
				arr[i]=new pair(l,r,i);
			}
			Arrays.sort(arr);
			suf[n-1]=arr[n-1].l;
			for(int i=n-2;i>=0;i--)
			suf[i]=Math.min(suf[i+1],arr[i].l);

			int i=0;
			for(;i<n-1;i++)
			{
				if(arr[i].r < suf[i+1])
				{
					flag=true;
					break;
				}
			}
			if(flag==false)
			{
				System.out.println("-1");
				continue;
			}
			int[] ans = new int[n];
			for(int j=0;j<=i;j++)
			ans[arr[j].i]=1;
			for(int j=i+1;j<n;j++)
			ans[arr[j].i]=2;
			for(int val : ans)
			System.out.print(val+" ");
			System.out.println();
		}
	}
	public static int gcd(int a,int b)
	{
		if(b == 0)
		return a;
		return gcd(b,a%b);
	}
}
