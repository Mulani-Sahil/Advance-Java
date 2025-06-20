package connectivity;
import java.sql.*;
import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class RSMJTable extends JFrame implements ActionListener {
	Connection con;
	Statement st;
	JTable tb1;
	Label l1,l2,l3;
	TextField t1,t2,t3;
	Button b1,b2,b3;
	RSMJTable(){
	 setVisible(true);
	 setSize(2000,1000);
	 setLayout(new FlowLayout());
	 l1=new Label("Enter Employee Number: ");
	 t1=new TextField(10);
	 l2=new Label("Enter Employee name: ");
	 t2=new TextField(10);
	 l3=new Label("Enter Employee Salary: ");
	 t3=new TextField(10);
	 b1=new Button("Insert");
	 b2=new Button("Show");
	 b3=new Button("Exit");
	 add(l1);add(t1);
	 add(l2);add(t2);
	 add(l3);add(t3);
	 add(b1);add(b2);
	 add(b3);
	 b1.addActionListener(this);
	 b2.addActionListener(this);
	 b3.addActionListener(this);
	 try{
			Class.forName("org.postgresql.Driver");
	        con=DriverManager.getConnection("jdbc:postgresql://localhost:4321/postgres","postgres","bcs123");
	        st=con.createStatement();
	        
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"Error: "+e);
		}
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1){
        	try{
        		int en=Integer.parseInt(t1.getText());
            	String ename=t2.getText();
            	int sal=Integer.parseInt(t3.getText());
            	int k=st.executeUpdate("insert into emp values("+en+",'"+ename+"',"+sal+")");
            	if(k>0){
            		JOptionPane.showMessageDialog(this,"Inserted Successfully");
            	}
            	else{
            		JOptionPane.showMessageDialog(this,"Inserted Unsuccessfully");
            	}
    
        	}catch(Exception e){
        		JOptionPane.showMessageDialog(this,"Error: "+e);
        	}
        }
		
		if(ae.getSource()==b2){
		  try{
			  ResultSet rs=st.executeQuery("select * from emp");
			  Vector head=new Vector();
			  head.add("Eno");
			  head.add("Ename");
			  head.add("Salary");
			  
			  Vector data=new Vector();
			  while(rs.next()){
				  Vector row=new Vector();
				  row.add(rs.getString(1));
				  row.add(rs.getString(2));
				  row.add(rs.getString(3));
				  data.add(row);
			  }
			  tb1=new JTable(data,head);
			  JScrollPane jsp=new JScrollPane(tb1);
			  add(jsp);
		  }catch(Exception e){
			  JOptionPane.showMessageDialog(this,"Error: "+e );
		  }
		}
        if(ae.getSource()==b3){
			dispose();
        }
	}
public static void main(String[] args) {
	new RSMJTable();
}
}
