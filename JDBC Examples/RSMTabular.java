package connectivity;
import java.sql.*;
import java.util.*;
public class RSMTabular {
	public static void main(String[] args) {
		try{
			Class.forName("org.postgresql.Driver");
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:4321/postgres","postgres","bcs123");
		    Statement st=con.createStatement();
		    Scanner sc=new Scanner(System.in);
		   System.out.println("Enter Table Name: ");
		    String tname=sc.next();
		    
			ResultSet rs=st.executeQuery("Select * from "+tname);
			ResultSetMetaData rsm = rs.getMetaData();
			
			int n=rsm.getColumnCount();
			for(int i=1;i<=n;i++){
				System.out.print(rsm.getColumnName(i)+"\t");
			}
			System.out.println("\n..............................\n");
			while(rs.next()){
				for(int i=1;i<=n;i++){
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.print("\n");
			}
		}catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
