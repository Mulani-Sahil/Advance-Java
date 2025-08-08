/*a) Accept ‘n’ integers from the user. Store and display integers in sorted order having 
proper collection class. The collection should not accept duplicate elements.*/
package assignment1;
import java.util.*;
public class sBa {
public static void main(String[] args) 
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Limit: ");
	int n=sc.nextInt();
	TreeSet<Integer> ts=new TreeSet<Integer>();
	System.out.println("Start entering elements: ");
	for(int i=0;i<n;i++)
	{
		ts.add(sc.nextInt());
	}
	System.out.println(ts);
}
}
