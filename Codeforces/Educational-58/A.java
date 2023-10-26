import java.io.*;
import java.util.*;

public class A {
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
			int l = scn.nextInt();
			int r = scn.nextInt();
			int d = scn.nextInt();
			if(l-1 >= d)
			{
				System.out.println(d);
			}
			else
			{
				System.out.println(r+d-r%d);
			}
		}
	}
	public static int gcd(int a,int b)
	{
		if(b == 0)
		return a;
		return gcd(b,a%b);
	}
}
