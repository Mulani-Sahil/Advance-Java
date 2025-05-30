package EventHandling;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class itemlistenerex extends Applet implements ItemListener{
	Checkbox c1,c2,c3,c4,c5,c6,c7,c8;
	CheckboxGroup cg1,cg2;
	Panel p1,p2,p3;
	public void init(){
		cg1=new CheckboxGroup();
		cg2=new CheckboxGroup();
		c1=new Checkbox("Maharashtra",cg1,true);
		c2=new Checkbox("Gujrat",cg1,true);
		c3=new Checkbox("Rajasthan",cg1,true);
		c4=new Checkbox("Karnataka",cg1,true);
		
		c5=new Checkbox("Gandhinagar",cg2,true);
		c6=new Checkbox("Jaipur",cg2,true);
		c7=new Checkbox("Banglore",cg2,true);
		c8=new Checkbox("Mumnai",cg2,true);
		
		p1=new Panel();
		p1.setLayout(new GridLayout(4,1));
		p1.add(c1);p1.add(c2);p1.add(c3);p1.add(c4);
		
		p2=new Panel();
		p2.setLayout(new GridLayout(4,1));
		p2.add(c5);p2.add(c6);p2.add(c7);p2.add(c8);
		
		p3=new Panel();
		p3.setLayout(new GridLayout(1,2));
		p3.add(p1);p3.add(p2);
		add(p3);
		
		c1.addItemListener(this);
		c2.addItemListener(this);
		c3.addItemListener(this);
		c1.addItemListener(this);
		
	}
	@Override
	public void itemStateChanged(ItemEvent ie) {
			if(c1.getState()==true)
				c8.setState(true);
			if(c2.getState()==true)
				c5.setState(true);
			if(c3.getState()==true)
				c6.setState(true);
			if(c4.getState()==true)
				c7.setState(true);
			
	}
}
