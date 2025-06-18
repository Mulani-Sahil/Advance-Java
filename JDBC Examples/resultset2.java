package connectivity;
import java.sql.*;
import java.util.*;
public class resultset2 {
public static void main(String[] args) {
	try{
	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:4321/postgres","postgres","bcs123");
   Statement st=con.createStatement();
   Scanner sc=new Scanner(System.in);
   System.out.println("Enter Student Roll number to search: ");
   int rn=sc.nextInt();
   ResultSet rs=st.executeQuery("select * from student where rno="+rn);
   if(rs.next()){
	   System.out.println("Student Roll Number: "+rs.getInt(1));
	   System.out.println("Student Name: "+rs.getString(2));
	   System.out.println("Student Percentage Scored: "+rs.getFloat(3));
	   System.out.println("Student Grade Achived: "+rs.getString(4));
   }
   else{
	   System.out.println("Recod Not found.....");
   }
	}catch(Exception e){
	System.out.println("Error="+e);
}
	}
}
