package EventHandling;
import java.awt.Color;
import java.awt.TextField;
import java.awt.event.*;
import java.applet.*;
public class FocusDemo extends Applet implements FocusListener {
	
	TextField t1,t2,t3;
	public void init(){
	 t1=new TextField(10);
	 t2=new TextField(10);
	 t3=new TextField(10);
	 
	 add(t1);add(t2);add(t3);
	 
	 t1.addFocusListener(this);
	 t2.addFocusListener(this);
	 t3.addFocusListener(this);
 }
	
	@Override
	public void focusGained(FocusEvent arg0) {
	 
		if(t1.hasFocus())
			t1.setBackground(Color.yellow);
		else
			t1.setBackground(Color.white);
		
		if(t2.hasFocus())
			t2.setBackground(Color.yellow);
		else
			t2.setBackground(Color.white);
		
		if(t3.hasFocus())
			t3.setBackground(Color.yellow);
		else
			t3.setBackground(Color.white);
		
		
	}
	
	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
