/*b) Write a java program to read ‘n’ names of your friends, store it into linked list, also 
display contents of the same. */
package assignment1;
import java.util.*;
public class sAb {
public static void main(String[] args) 
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter friends number to enter: ");
	int n=sc.nextInt();
	LinkedList names=new LinkedList();
	System.out.println("Start Entering names: ");
	for(int i=0;i<n;i++)
	{
		names.add(sc.next());
	}
	System.out.println(names);
}
}
