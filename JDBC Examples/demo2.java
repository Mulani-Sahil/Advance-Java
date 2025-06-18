/*Update name and Salary of the given Employee*/
package connectivity;
import java.sql.*;
import java.util.*;
public class demo2 {
public static void main(String[] args) throws Exception{
	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:4321/postgres","postgres","bcs123");
	Statement st=con.createStatement();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter employee Number: ");
	int en=sc.nextInt();
	System.out.println("Enter new Name and Salary: ");
	String name=sc.next();
	int esal=sc.nextInt();
	int k = st.executeUpdate("UPDATE emp SET name='" + name + "', sal=" + esal + " WHERE emp.eno=" + en);
	if(k>0){
		System.out.println("Update done.......");
	}else{
		System.out.println("Update not done..........");
	}
	}
}
