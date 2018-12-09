package lab_3;
import java.io.*;
import java.util.HashSet;
class searchsort
{
	static void createarray(String a1[],String a2[]) throws IOException
	{
		File ipf1=new File("D:\\Suman CSE\\Suman cse desktop\\JAVA_ASSIGNMENTS\\HW3\\HW2-dictionary.txt");
		File ipf2=new File("D:\\Suman CSE\\Suman cse desktop\\JAVA_ASSIGNMENTS\\HW3\\HW3-unsorted-keywords.txt");
		

		BufferedReader r1=new BufferedReader(new FileReader(ipf1));
		BufferedReader r2=new BufferedReader(new FileReader(ipf2));
		
		int i=0;
		int j=0;
		String c,d;
		while((d=r2.readLine())!=null &&(c=r1.readLine())!=null )
		{
			a1[i]=c;
			a2[j]=d;
			//System.out.println(a1[i]);
			//System.out.println(a2[j]);
			i++;
			j++;
		}
		while((c=r1.readLine())!=null)
		{
			a1[i]=c;
			i++;
		}
		while((d=r2.readLine())!=null)
		{
			a2[j]=d;
			j++;
		}
		r1.close();
		r2.close();
	}
	
	static void sorting(String a1[],String a2[])
	{
		String temp;
		for(int i=0;i<16000;i++)
		{
			
			for(int j=i+1;j<16000;j++)
			{
				//System.out.println(a1[i] + "  " +a1[j]);
				if(a1[i].compareTo(a1[j])>0)
				{
					temp=a1[i];
					a1[i]=a1[j];
					a1[j]=temp;
				}
			}
			
		}
		for(int i=0;i<84;i++)
		{
			for(int j=i+1;j<84;j++)
			{
				if(a2[i].compareTo(a2[j])>0)
				{
					temp=a2[j];
					a2[j]=a2[i];
					a2[i]=temp;
				}
			}
		}
	}
	static HashSet<String> createset(String a1[])
	{
		HashSet <String> set=new HashSet<String>();
		for(int i=0;i<16000;i++)
		{
			set.add(a1[i]);
		}
		return set;
	}
	static void compare(HashSet<String> set,String a2[])
	{
		int count=0;
		for(int i=0;i<84;i++)
		{
			if(!set.contains(a2[i]))
			{
				count++;
				System.out.println("Keyword not found :" + a2[i] );
			}
		}
		System.out.println("number of keywords missing :" + count);
	}
	static void outputfn(String a1[],String a2[])
	{
		HashSet <String> set=createset(a1);
		compare(set,a2);
	}
	
	public static void main(String args[])  throws IOException
	{
		String a1[]=null;
		String a2[]=null;
		a1=new String[16000];
		a2=new String[84];
		createarray(a1,a2);   //this function is used to create two array of string values to whom sorting is to be applied 
		sorting(a1,a2);  //this method sorts both the arrays passed to it
		outputfn(a1,a2);
	}
}
