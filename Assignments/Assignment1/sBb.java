/*b) Write a program to sort HashMap by keys and display the details before sorting and 
after sorting. */
package assignment1;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
public class sBb {

	public static void main(String[] args) {
		HashMap hm=new HashMap();
		hm.put("z","IPhone");
		hm.put("a","Samsung");
		hm.put("y","IQOO");
		hm.put("p","Vivo");
		 System.out.println("Before Sorting: ");
		 System.out.println(hm);
		 System.out.println("After sorting: ");
		 TreeMap tm=new TreeMap(hm);
		 System.out.println(tm);

	}

}
