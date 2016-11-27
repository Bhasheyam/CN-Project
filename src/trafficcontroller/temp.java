package trafficcontroller;

public class temp {
	static int i=0;
	static int c=0;
	public static void returnn(int s1,int s3)
	{
		s1=s3;
	}
	public static int add()
	{
		c=3;
		returnn(i,c);
		return i;
	}
	
	
public static void main(String s[])
{
	int a=temp.add();
	System.out.println(a);
	
}
}
