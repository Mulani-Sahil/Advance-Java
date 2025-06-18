package connectivity;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;
public class demo3 extends Frame implements ActionListener{
	Label l1,l2,l3;
	TextField t1,t2,t3;
	Button b1,b2,b3;
	demo3(){
		setVisible(true);
		setSize(300,200);
		setLayout(new FlowLayout());
		l1=new Label("Enter Employee Number: ");
		l2=new Label("Enter Employee Name: ");
		l3=new Label("Enter Employee Salary: ");
		t1=new TextField(10);
		t2=new TextField(10);
		t3=new TextField(10);
		b1=new Button("insert");
		b2=new Button("Delete");
		b3=new Button("Exit Screen");
	   add(l1);add(t1);
	   add(l2);add(t2);
	   add(l3);add(t3);
	   add(b1);add(b2);
	  add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{  
		try{
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:4321/postgres","postgres","bcs123");
		Statement st=con.createStatement();
		if(ae.getSource()==b1){
			int en=Integer.parseInt(t1.getText());
			String name=t2.getText();
			int sal=Integer.parseInt(t3.getText());			
			int k=st.executeUpdate("INSERT INTO emp VALUES (" + en + ", '" + name + "', " + sal + ")");
			if(k>0)
				JOptionPane.showMessageDialog(this,"Insert Successfully");
			else
				JOptionPane.showMessageDialog(this,"Insertion Unsuccessfull ");
		}
		
		if(ae.getSource()==b2){
			int eno=Integer.parseInt(t1.getText());
			int k = st.executeUpdate("DELETE FROM emp WHERE eno = " + eno);
			if(k>0)
				JOptionPane.showMessageDialog(this,"Delete Successfully");
			else
				JOptionPane.showMessageDialog(this,"Record not found");
		
		}
		if(ae.getSource()==b3){
			dispose();
		}
		st.close();
		con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(this,"Error="+e);
		}
    		
	}
public static void main(String[] args) {
	new demo3();
}
}
