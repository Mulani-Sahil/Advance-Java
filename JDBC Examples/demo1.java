package connectivity;
import java.sql.*;
public class demo1 {
	public static void main(String[] args)throws Exception {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection(
			    "jdbc:postgresql://localhost:4321/postgres", "postgres", "bcs123");

		Statement st=con.createStatement();
		int k=st.executeUpdate("insert into emp values(103,'Sahil',50000)");
		if(k>0){
			System.out.println("Insertion Successfull");
		}
		else{
			System.out.println("Insertion Unsuccesfull......");
		}
	}
}
