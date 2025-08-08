/*a) Write a java program to accept names of ‘n’ cities, insert same into array list 
collection and display the contents of same array list, also remove all these elements. */
package assignment1;
import java.util.*;
public class sAa {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList names=new ArrayList();
		System.out.println("Enter cities number: ");
		int n=sc.nextInt();
		System.out.println("Enter names:");
		for(int i=0;i<n;i++)
		{
			names.add(sc.next());
		}
		System.out.println(names);
	 names.clear();
	}
}
