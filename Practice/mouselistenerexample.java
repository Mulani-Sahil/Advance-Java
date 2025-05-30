package EventHandling;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class mouselistenerexample extends Applet implements MouseMotionListener{
	int x,y;
	public void init(){
		addMouseMotionListener(this);
	}
	public void update(Graphics g){
		g.setColor(Color.green);
		g.drawLine(x, y, x+2, y+1);
	}
	@Override
	public void mouseDragged(MouseEvent me) {
		x=me.getX();
		y=me.getY();
		repaint();		
	}
	@Override
	public void mouseMoved(MouseEvent me) {
	
		
	}
}
