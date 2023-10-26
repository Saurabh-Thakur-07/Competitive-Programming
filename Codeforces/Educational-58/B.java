import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner scn = new Scanner(System.in);
		int te = 1;
		// System.out.println(t);
		while(te-->0)
		{
			String s = scn.next();
			boolean flag=false;
			int i=0,n=s.length();
			for(;i<n;i++)
			{
				char ch = s.charAt(i);
				if(ch == '[')
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
			flag=false;
			for(;i<n;i++)
			{
				char ch = s.charAt(i);
				if(ch == ':')
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
			flag=false;
			int j=n-1;
			int c=0;
			for(;j>i;j--)
			{
				char ch = s.charAt(j);
				if(ch == ']')
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
			flag=false;
			for(;j>i;j--)
			{
				char ch = s.charAt(j);
				if(ch == ':')
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
			for(int k=i+1;k < j;k++)
			{
				char ch = s.charAt(k);
				if(ch == '|')
				c++;
			}
			c+=4;
			System.out.println(c);
		}
	}
	public static int gcd(int a,int b)
	{
		if(b == 0)
		return a;
		return gcd(b,a%b);
	}
}
