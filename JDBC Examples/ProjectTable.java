/*Create a PROJECT table with fields project_id, Project_name, Project_description, 
Project_Status. etc. Insert values in the table. Display all the details of the PROJECT 
table in a tabular format on the screen.(using swing).  */
package connectivity;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;
import java.awt.event.*;
import java.awt.*;
public class ProjectTable extends JFrame implements ActionListener {
    JTable tb1;
    Connection con;
    Statement st;
	JButton b1,b2; 
    ProjectTable(){
	  setVisible(true);
	  setSize(1000,1000);
	  setLayout(new FlowLayout());
	  b1=new JButton("Details");
	  b2=new JButton("Exit");
	  add(b1);
	  add(b2);
	  b1.addActionListener(this);
	  b2.addActionListener(this);
	  try{
		    Class.forName("org.postgresql.Driver");
	        con=DriverManager.getConnection("jdbc:postgresql://localhost:4321/postgres","postgres","bcs123");
	        st=con.createStatement();
	  }catch(Exception e){
			JOptionPane.showMessageDialog(this, "Error: "+e);
	  }
    }
	@Override
public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==b1){
			  try{
				  ResultSet rs=st.executeQuery("select * from PROJECT");
				  Vector head=new Vector();
				  head.add("Project_ID");
				  head.add("Project_Name");
				  head.add("Project_Description");
				  head.add("Project_Status");
				  
				  Vector data=new Vector();
				  while(rs.next()){
					  Vector row=new Vector();
					  row.add(rs.getString(1));
					  row.add(rs.getString(2));
					  row.add(rs.getString(3));
					  row.add(rs.getString(4));
					  data.add(row);
				  }
				  tb1=new JTable(data,head);
				  JScrollPane jsp=new JScrollPane(tb1);
				  add(jsp);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(this, "Error: "+e);
		}
	}
	if(ae.getSource()==b2){
		dispose();
	}
}
	public static void main(String[] args) {
	new ProjectTable();
}
}
