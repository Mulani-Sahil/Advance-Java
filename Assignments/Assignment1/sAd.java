/* Create the hash table that will maintain the mobile number and student name. Display 
the contact list.*/
package assignment1;
import java.util.*;
public class sAd {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Hashtable ht=new Hashtable();
	System.out.println("Enter count: ");
	int n=sc.nextInt();
	for(int i=0;i<n;i++) {
	  System.out.println("Enter Name of the student: ");
	  String name=sc.next();
	  System.out.println("Enter Contact number: ");
	  int num=sc.nextInt();
	  ht.put(name,num);
	}
	System.out.println("Contact List");
	System.out.println(ht);

	}

}
