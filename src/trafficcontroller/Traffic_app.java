package trafficcontroller;

import java.util.Scanner;

public class Traffic_app {
	
	private final static double atob=3;
	private final static double ctod=1;
	private final static double atod=2;
	private final static double ctob=3;
	private final static double btoc=5;
	private final static double btoa=4;
	private final static double dtoa=5;
	private  final static double dtoc=6;
	private  static double uatob=0.0;
	private static double uctod=0.0;
	private static double uatod=0.0;
	private  static double uctob=0.0;
	private  static double ubtoc=0.0;
	private  static double ubtoa=0.0;
	private  static double udtoa=0.0;
	private  static double udtoc=0.0;
	private  static double matob=0;
	private static double mctod=0;
	private static double matod=0;
	private  static double mctob=0;
	private  static double mbtoc=0;
	private  static double mbtoa=0;
	private  static double mdtoa=0;
	private  static double mdtoc=0;
	private static double alpha=0.0d;
	
	
	//calculating uij
public static double calculateu(double i,double j)
{
	double u;
	u=(double)i/j;
	return u;
}
//cost calculation of each path.
//we considered every path cost as one if it is utilized fully
//say for the example of the if path A->B is 3. 
//if its path capacity 3 is fully used is considered as 1 cost.
public static double costcalculation(double used,double present)
{
	double d;
	d=(double)used/present;
	return d;
	
}
//alpha calculation.
public static double alphavalue(double i,double t)
{
	return i/t;
}
//increment the alpha.
public static void alphaplus()
{
	alpha=alpha+0.01;
}
//producing the alpha value for the first alpha calculation
public static double alphagenerator()
{
	return alpha;
}
//reset the value to 0 to use it another path
public static void alphareset()
{
	alpha=0.0;
}
static double temp1;
static double temp2;
static double temp3 = 0;
static double temp4 = 0;
static double temp5 = 0;
static double temp6 = 0;
static double u1;
static double u2;
static double u3;
static double u4;


//calculating the cost
private static String Calculatepath(String s1, String s2, int i,String d) {


		double d1=0.0,d2=0.0,alp=0.0,alp1=0.0;
	
	if(s1.equals("A")&&s2.equals("C")&d.equals(""))
	{
		
	
		while(uatob<atob && uatob<i)
		{
			 d1=alphagenerator();
			 d2=d1*i;
			 uatob=d2;
			alphaplus();
		
		}
		
		 if(uatob>btoc )
		 {
			 int o=(int)(d2);
			 int k=(int)(o-btoc);
			 uatob=uatob-k;
			 d2=uatob;
			 
			 ubtoc=ubtoc+uatob;
		 }
		 else
		 {
			 ubtoc=uatob;
		 }
		 if((double)i>uatob)
		 {
			 int o=(int)uatob;
			 int t=(int) (i-o);
			 
			 temp1=costcalculation(uatob,atob);
			temp2=costcalculation(ubtoc,btoc);
			
			temp3=temp1+temp2;
			matob=matob+uatob;
			mbtoc=mbtoc+ubtoc;
			u1=calculateu(matob,atob);
			u2=calculateu(mbtoc,btoc);
			alp=alphavalue(d2,i);
			 alp1=1-alp;
		 alphareset();
			alphareset();
			Calculatepath("A","B",t,"D");
			
			
		 }
		 else
		 {
			
			 temp1=costcalculation(d2,atob);
				temp2=costcalculation(d2,btoc);
				matob=matob+uatob;
				mbtoc=mbtoc+ubtoc;
				u1=calculateu(matob,atob);
				u2=calculateu(mbtoc,btoc);
				 alp=alphavalue(d2,i);
				 alp1=1-alp;
			 temp3=temp1+temp2;
			 alphareset();
			 Calculatepath("A","B",i,"D");
			 temp6=temp4+temp5;
			 if(temp6>=temp3)
			 {
				 return"alpha(traffic control1) is "+alp+" alpha(traffic control2) is "+alp1+"\n"+"\n"+"Utilisation of link1,link2- "+u1+"\t"+u2+"\n"+"\n"+"cost1 is "+temp3+ " & "+"cost2 is 0"; 
			 }else
			 {
				 return"alpha(traffic control1) is "+alp+" alpha(traffic control2) is "+alp1+"\n"+"\n"+"Utilisation of link3,link4- "+u3+"\t"+u4+"\n"+"\n"+"cost1 is 0"+ " & "+"cost2 is"+ temp6; 
			 }
		 }
	}
	else if(d.equals("D")&&s1.equals("A"))
	{
		
		while(uatod<atod&& uatod<i)
		{
			 d1=alphagenerator();
			 d2=d1*i;
			 uatod=d2;
			alphaplus();
		}
		uatod=Math.floor(uatod);
		
		 if(uatod>dtoc)
		 {
			 int k=(int)(d2-dtoc);
			 uatod=uatod-k;
			 d2=d2-k;
			 i=i-k;
			 udtoc=udtoc+uatod;
		 }
		 else
		 {
			 udtoc=uatod;
		 }
		 if(i>udtoc)
		 {
			 int t=(int) (i-d2);
		    uatod=uatod+t;
		    udtoc=udtoc+t;
		    d2=d2+t;
		    matod= matod+uatod;
		    mdtoc=mdtoc+udtoc;
		    u3=calculateu(matod,atod);
			u4=calculateu(mdtoc,dtoc);
			 temp4=costcalculation(uatod,atod);
				temp5=costcalculation(udtoc,dtoc);
			 
		 }
		 else
		 {
			 matod= matod+uatod;
			    mdtoc=mdtoc+udtoc;
			 temp4=costcalculation(d2,atod);
				temp5=costcalculation(d2,dtoc);	
			u3=calculateu(matod,atod);
			u4=calculateu(mdtoc,dtoc);
			
			 
			
			 
		 }
		
	}
	if(s1.equals("B")&&s2.equals("D")&d.equals(""))
	{
		
	
		while(ubtoc<btoc && ubtoc<i)
		{
			 d1=alphagenerator();
			 d2=d1*i;
			 ubtoc=d2;
			alphaplus();
		
		}
		
		 if(ubtoc>ctod )
		 {
			 int o=(int)(ubtoc);
			 int k=(int)(o-ctod);
			 ubtoc=ubtoc-k;
			 d2=ubtoc;
			 
			 uctod=uctod+ubtoc;
		 }
		 else
		 {
			 uctod=ubtoc;
		 }
		 if((double)i>ubtoc)
		 {
			 int o=(int)ubtoc;
			 int t=(int) (i-o);
			 
			 temp1=costcalculation(ubtoc,btoc);
			temp2=costcalculation(uctod,ctod);
			temp3=temp1+temp2;
			mbtoc=mbtoc+ubtoc;
			mctod=mctod+uctod;
			u1=calculateu(mbtoc,btoc);
			u2=calculateu(mctod,ctod);
			alp=alphavalue(d2,i);
			 alp1=1-alp;
		 alphareset();
			alphareset();
			Calculatepath("B","D",t,"A");
			
		 }
		 else
		 {
			 temp1=costcalculation(ubtoc,btoc);
				temp2=costcalculation(uctod,ctod);
			 temp3=temp1+temp2;
			 mbtoc=mbtoc+ubtoc;
				mctod=mctod+uctod;
				u1=calculateu(mbtoc,btoc);
				u2=calculateu(mctod,ctod);
			 alp=alphavalue(d2,i);
			alp1=1-alp;
			 alphareset();
			 Calculatepath("B","D",i,"A");
			 temp6=temp4+temp5;
			 if(temp6>=temp3)
			 {
				 return"alpha(traffic control1) is "+alp+" alpha(traffic control2) is "+alp1+"\n"+"\n"+"Utilisation of link1,link2- "+u1+"\t"+u2+"\n"+"\n"+"cost1 is "+temp3+ " & "+"cost2 is 0"; 
			 }else
			 {
				 return"alpha(traffic control1) is "+alp+" alpha(traffic control2) is "+alp1+"\n"+"\n"+"Utilisation of link3,link4- "+u3+"\t"+u4+"\n"+"\n"+"cost1 is 0"+ " & "+"cost2 is"+ temp6; 
			 }
			
		 }
	}
	else if(d.equals("A")&&s1.equals("B"))
	{
		
		while(ubtoa<i && ubtoa<btoa)
		{
			 d1=alphagenerator();
			 d2=d1*i;
			 ubtoa=d2;
			alphaplus();
		}
			double d3=d2-1;	
		 if(d3>atod)
		 {
			 int k=(int)(d2-btoa);
			 ubtoa=ubtoa-k;
			 d2=d2-k;
			 uatod=uatod+ubtoa;
		 }
		 else
		 {
			 uatod=d2;
		 }
		 if(i>d2)
		 {
			 int t=(int) (i-d2);
		    ubtoa=ubtoa+t;
		    uatod=uatod+t;
		    d2=d2+t;
		    mbtoa=mbtoa+ubtoa;
		    matod=matod+uatod;
		    u3=calculateu(mbtoa,btoa);
			u4=calculateu(matod,atod);
			temp4=costcalculation(ubtoa,btoa);
			temp5=costcalculation(uatod,atod);
			 
		 }
		 else
		 {
			    mbtoa=mbtoa+ubtoa;
			    matod=matod+uatod;
			    u3=calculateu(mbtoa,btoa);
				u4=calculateu(matod,atod);
			 temp4=costcalculation(ubtoa,btoa);
				temp5=costcalculation(uatod,atod);
			 
			
			 
		 }
		
	}
	if(s1.equals("C")&&s2.equals("A")&d.equals(""))
	{
		
	
		while(uctob<ctob && uctob<i)
		{
			 d1=alphagenerator();
			 d2=d1*i;
			 uctob=d2;
			alphaplus();
		
		}
		
		 if(uctob>btoa )
		 {
			 int o=(int)(d2);
			 int k=(int)(o-btoa);
			 uctob=uctob-k;
			 d2=uctob;
			 
			 ubtoa=ubtoa+uctob;
		 }
		 else
		 {
			 ubtoa=uctob;
		 }
		 if((double)i>ubtoa)
		 {
			 int o=(int)ubtoa;
			 int t=(int) (i-o);
			 
			 temp1=costcalculation(uctob,ctob);
			temp2=costcalculation(ubtoa,btoa);
			temp3=temp1+temp2;
			mctob=mctob+uctob;
			mbtoa=mbtoa+ubtoa;
			u1=calculateu(mctob,ctob);
			u2=calculateu(mbtoa,btoa);
			alp=alphavalue(uatob,i);
			 alp1=1-alp;
		 alphareset();
			alphareset();
			Calculatepath("C","A",t,"D");
			
			
		 }
		 else
		 {
			 mctob=mctob+uctob;
				mbtoa=mbtoa+ubtoa;
			 u1=calculateu(mctob,ctob);
				u2=calculateu(mbtoa,btoa);
			 temp1=costcalculation(uctob,ctob);
				temp2=costcalculation(ubtoa,btoa);
				 alp=alphavalue(uatob,i);
				 alp=Math.floor(alp);
				 alp1=1-alp;
			 temp3=temp1+temp2;
			 alphareset();
			 Calculatepath("C","A",i,"D");
			 temp6=temp4+temp5;
			 if(temp6>=temp3)
			 {
				 return"alpha(traffic control1) is "+alp+" alpha(traffic control2) is "+alp1+"\n"+"\n"+"Utilisation of link1,link2- "+u1+"\t"+u2+"\n"+"\n"+"cost1 is "+temp3+ " & "+"cost2 is 0"; 
			 }else
			 {
				 return"alpha(traffic control1) is "+alp+" alpha(traffic control2) is "+alp1+"\n"+"\n"+"Utilisation of link3,link4- "+u3+"\t"+u4+"\n"+"\n"+"cost1 is 0"+ " & "+"cost2 is"+ temp6; 
			 }
			
		 }
	}
	else if(d.equals("D")&&s1.equals("C"))
	{
		
		while(uctod<ctod&& uctod<i)
		{
			 d1=alphagenerator();
			 d2=d1*i;
			 uctod=d2;
			alphaplus();
		}
		
		 if(uctod>dtoa)
		 {
			 int k=(int)(d2-dtoc);
			 uctod=uctod-k;
			 d2=uctod;
			 i=i-k;
			 udtoa=udtoa+uctod;
		 }
		 else
		 {
			 udtoa=uctod;
		 }
		 if(i>udtoa)
		 {
			 int t=(int) (i-d2);
		    uctod=uctod+t;
		    udtoa=udtoa+t;
		    d2=d2+t;
		    mctod=mctod+uctod;
		    mdtoa=mdtoa+udtoa;
		    u3=calculateu(mctod,ctod);
			u4=calculateu(mdtoa,dtoa);
			 temp4=costcalculation(d2,ctod);
				temp5=costcalculation(d2,dtoa);
			 
		 }
		 else
		 {
			   mctod=mctod+uctod;
			    mdtoa=mdtoa+udtoa;
			 u3=calculateu(mctod,ctod);
				u4=calculateu(mdtoa,dtoa);
			 temp4=costcalculation(d2,ctod);
				temp5=costcalculation(d2,dtoa);
			 
			
			 
		 }
		
	}

	
	temp6=temp4+temp5;
	return "alpha(traffic control1) is "+alp+" alpha(traffic control2) is "+alp1+"\n"+"\n"+"Utilisation of link1,link2,link3,link4- "+u1+"\t"+u2+"\t"+u3+"\t"+u4+"\n"+"\n"+"cost1 is "+temp3+ " & "+"cost2 is"+temp6+" ";
}
	

	public static void main(String s[])
	{  

	
		
			System.out.println("Follwoing are the path need to be calculated for traffic in the network");
			System.out.println("1:A->C=4");
			System.out.println("2:B->D=3");
			System.out.println("3:C->A=2");
			String s1=Traffic_app.Calculatepath("A","C",4,"");
			String s2=Traffic_app.Calculatepath("B","D",3,"");
			String s3=Traffic_app.Calculatepath("C","A",2,"");
	  System.out.println(s1);
	  System.out.println("");
	 System.out.println(s2);
	 System.out.println("");
	  System.out.println(s3);
	  
			System.out.println("Calculation completed");
			System.out.println("");
			System.out.println("-----------------------------------------------");
			System.out.println("");	
		
		
	}
	

}
