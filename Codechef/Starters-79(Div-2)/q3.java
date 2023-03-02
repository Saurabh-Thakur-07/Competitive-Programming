/* package codechef; // don't place package name! */



import java.util.*;

import java.lang.*;

import java.io.*;



/* Name of the class has to be "Main" only if the class is public. */

class Codechef

{

	public static void main (String[] args) throws java.lang.Exception

	{

		Scanner scn = new Scanner(System.in);

		int t = scn.nextInt();

		while(t-->0)

		{

		    int x = scn.nextInt();

		    int y = scn.nextInt();

		    if(Math.abs(x-y) <= 1)

		    {

		        int min = Math.min(x,y);

		        if(min%2==0)

		        System.out.println("CHEFINA");

		        else

		        System.out.println("CHEF");

		    }

		    else if(x > y)

		    System.out.println("CHEF");

		    else if(x < y)

		    System.out.println("CHEFINA");

		    else

		    {

		        if(x%2 == 0)

		        System.out.println("CHEFINA");

		        else

		        System.out.println("CHEF");

		    }

		}

	}

}


