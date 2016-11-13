package trafficcontroller;

import java.util.Scanner;

public class Traffic_app {
	
	private final int atoB=3;
	private final int ctod=1;
	private final int atod=2;
	private final int ctob=3;
	private final int btoc=5;
	private final int btoa=4;
	private final int dtoa=5;
	private final int dtoc=6;
	
	
	public static void Calculate(int j)
	{
		if (j==1)
		{
			System.out.println("Calculation completed");
			System.out.println("");
			System.out.println("-----------------------------------------------");
			System.out.println("");
		}
		else if(j==2)
		{
			System.out.println("Calculation completed");
			System.out.println("");
			System.out.println("-----------------------------------------------");
			System.out.println("");
		}
		else 
		{
			System.out.println("Calculation completed");
			System.out.println("");
			System.out.println("-----------------------------------------------");
			System.out.println("");
			
		}
	}
	public static void main(String s[])
	{  

		while(true)
		{
			int j = 0;
			System.out.println("select the route to sent the packet");
			System.out.println("1:A->C");
			System.out.println("2:B->D");
			System.out.println("3:C->A");
	    System .out.println("enter the Route:");
	    try
		{
	    Scanner in=new Scanner(System.in);
		
			j=in.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("enter 1 or 2 or 3 integer"+ e);
		}
		if(j>4 || j<0)
		{
			System.out.println("invalid entry");
		}
		else
		{
			Traffic_app.Calculate(j);
			
		}
		
		}	
	}

}
