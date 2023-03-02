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

	    int n = scn.nextInt();

	    int m = scn.nextInt();

	    int q = scn.nextInt();

	    while(q-- > 0)

	    {

	        long qi = scn.nextLong();

	        long sum = 0;

	        int i = 1;

	        while((sum + i*m) <= qi && i <= n)

	        {

	            sum += i*m;

                if(i == n)

                break;

	            i++;

                

	        }

            if(sum == qi)

            {

                System.out.println(1 +" "+i);

    	        for(int k = 1; k <= i ;k++)

    	        {

    	            System.out.print(m +" ");

    	        }

                System.out.println();

            }

            else

            {

                long caught = 0;

                int j = 1;

                while(j <= m)

                {

                    sum += i;

                    if(sum >= qi)

                    {

                        break;

                    }

                    j++;

                }

                if(sum < qi)

                {

                    System.out.println("-1");

                }

                else

                {

                    caught = sum - qi;

                    System.out.println(1 +" "+i);

                    for(int k = 1; k <= i ;k++)

                    {

                        if(k == caught)

                        {

                            System.out.print((m-1)+" ");

                        }

                        else if(k == i)

                        {

                            System.out.print(j+" ");

                        }

                        else

                        {

                            System.out.print(m +" ");

                        }

                    }

                    System.out.println();

                }

            }

	    }

	}

}

