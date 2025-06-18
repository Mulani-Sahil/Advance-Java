package connectivity;
import java.sql.*;
import java.util.*;
public class resultset {
public static void main(String[] args){
	try{
	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:4321/postgres","postgres","bcs123");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("Select * from emp");
	while(rs.next()){
		System.out.println("Emp no: "+rs.getInt(1));
		System.out.println("Emp Name: "+rs.getString(2));
		System.out.println("Emp Salary: "+rs.getInt(3));
        System.out.println("\n");
	}
}catch(Exception e){
 System.out.println("Error: "+e);	
}
}
}
