package TableExs;
import java.awt.*;
import java.util.*;
public class demo1 extends Frame{
 Choice ch;
 demo1(){
	 setVisible(true);
	 setSize(500,500);
	 ch=new Choice();
	 ch.add("SY");
	 ch.add("SY");
	 ch.add("SY");
	 ch.add("SY");
	 ch.add("SY");
	 ch.add("SY");
	 ch.add("SY");
	 ch.add("SY");
	 ch.add("SY");

	 add(ch);
	 add(ch,BorderLayout.NORTH);
 }
 public static void main(String[] args) {
	new demo1();
}
}
