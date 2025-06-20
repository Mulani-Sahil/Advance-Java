package connectivity;
import java.sql.*;
public class RSM {
public static void main(String[] args) {
	try{
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:4321/postgres","postgres","bcs123");
	    Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select * from emp");
		ResultSetMetaData rsm = rs.getMetaData();
		
		System.out.println("Number of Columns: "+rsm.getColumnCount());
		
		System.out.println("Column1 Name: "+rsm.getColumnLabel(1));
		System.out.println("Column2 Name: "+rsm.getColumnLabel(2));
		System.out.println("Column3 Name: "+rsm.getColumnLabel(3));
		
		System.out.println("Datatype of Column1: "+rsm.getColumnTypeName(1));
		System.out.println("Datatype of Column2: "+rsm.getColumnTypeName(2));
		System.out.println("Datatype of Column3: "+rsm.getColumnTypeName(3));
		
		System.out.println("Column1 Size: "+rsm.getColumnDisplaySize(1));
		System.out.println("Column2 Size: "+rsm.getColumnDisplaySize(2));
		System.out.println("Column3 Size: "+rsm.getColumnDisplaySize(3));
		
       }catch(Exception e){
		System.out.println("Error: "+e);
	}
}
}
