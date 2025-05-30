package LayourManagement;
import java.awt.*;
import java.awt.event.*;

public class GLayoutEx extends Frame implements ActionListener{
	Label l1,l2,l3;
	TextField t1,t2,t3;
	Button b1,b2,b3;
	
	GLayoutEx(){
		setVisible(true);
		setSize(500,400);
		setTitle("Addition Of Two Numbers: ");
		setLayout(new GridLayout(5,2));
		setBackground(Color.MAGENTA);
		l1=new Label("Enter No 1: ");
		l2=new Label("Enter No 2: ");
		l3=new Label("result: ");
		t1=new TextField(10);
		t2=new TextField(10);
		t3=new TextField(10);
		b1=new Button("Add");
		b2=new Button("Remove");
		b3=new Button("Exit");
		
		add(l1);add(t1);
		add(l2);add(t2);
		add(l3);add(t3);
		add(b1);add(b2);add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1){
			int n = Integer.parseInt(t1.getText());
			int n2 = Integer.parseInt(t2.getText());
			int n3 = n + n2;
			t3.setText(Integer.toString(n3));
		}
		
		if(ae.getSource()==b2){
			t1.setText("");
			t2.setText("");
			t3.setText("");
		}
		
		if(ae.getSource()==b3){
			dispose();
		}
	}
	public static void main(String[] args) {
		new GLayoutEx();
	}

}
