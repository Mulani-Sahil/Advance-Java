package LayourManagement;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class FLayoutEx extends Frame implements ActionListener{

	Choice c1,c2,c3;
	Button b1;
	TextArea ta;

	
	FLayoutEx(){
		setVisible(true);
		setSize(500,500);
		setTitle("NotePad Shortcut");
		setLayout(new FlowLayout());
		c1=new Choice();
		c1.add("Arial");
		c1.add("Times New Roman");
		c1.add("Sans Serief");
		
		c2=new Choice();
		c2.add("PLAIN");
		c2.add("ITALIC");
		c2.add("BOLD");
		c2.add("UNDERLINE");
		
		c3=new Choice();
		for(int i=0;i<100;i++){
			c3.add(""+i);
		}
		
		b1=new Button("ok");
		ta=new TextArea();
		add(c1);add(c2);add(c3);add(b1);add(ta);
	
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose(); // Closes the current window
                System.exit(0); // Exits the application
            }
        });
		b1.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==b1){
			String fname=c1.getSelectedItem().toString();
			String fstyle=c2.getSelectedItem().toString();
			int fsize=Integer.parseInt(c3.getSelectedItem());
			Font f1=null;
			if(fstyle.equals("BOLD"))
				f1=new Font(fname,Font.BOLD,fsize);
			if(fstyle.equals("ITALIC"))
				f1=new Font(fname,Font.ITALIC,fsize);
			
			ta.setFont(f1);
		}
		
		
	}
	
	public static void main(String[] args) {
		new FLayoutEx();

	}
}
