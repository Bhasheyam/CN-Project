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
	private  final int dtoc=6;
	private  static int uatoB=0;
	private static int uctod=0;
	private static int uatod=0;
	private  static int uctob=0;
	private  static int ubtoc=0;
	private  static int ubtoa=0;
	private  static int udtoa=0;
	private  static int udtoc=0;
public double calculateu(int i,int j)
{
	double u;
	u=(double)i/j;
	return u;
}
public double caostcalculation(int i,int j)
{
	double d;
	d=(double)i/j;
	return d;
	
}
private static String Calculatepath(String s1, String s2, int i) {

	double alpha;
	if(s1.equals("A")&&s2.equals("C"))
	{
		
	}
	return "";
}
	
	
	
	
	public static void main(String s[])
	{  

	
			int j = 0;
			System.out.println("Follwoing are the path need to be calculated for traffic in the network");
			System.out.println("1:A->C=4");
			System.out.println("2:B->D=3");
			System.out.println("3:C->A=2");
			String s1=Traffic_app.Calculatepath("A","c",4);
			String s2=Traffic_app.Calculatepath("B","D",3);
			String s3=Traffic_app.Calculatepath("C","A",2);
	  System.out.println(s1);
	  System.out.println(s2);
	  System.out.println(s3);
	  
			System.out.println("Calculation completed");
			System.out.println("");
			System.out.println("-----------------------------------------------");
			System.out.println("");	
		
		
	}
	

}
