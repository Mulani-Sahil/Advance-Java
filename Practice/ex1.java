package appletexs;

import java.applet.Applet;
import java.awt.*;

/*
<applet code="ex1.class" width="400" height="300"></applet>
*/

public class ex1 extends Applet {
    List lst1;
    TextField t1;
    Button b1;
    Label l1, l2;

    public void init() {
        // Initialize components
        l1 = new Label("Enter Product: ");
        t1 = new TextField(15);
        l2 = new Label("All Products: ");
        lst1 = new List();
        b1 = new Button("Add");

        // Add components to the applet
        add(l1);
        add(t1);
        add(b1);
        add(l2);
        add(lst1);
    }

    public boolean action(Event e, Object o) {
        if (e.target == b1) {
            String item = t1.getText();
            if (!item.isEmpty()) {
                lst1.add(item);
                t1.setText("");
            }
            return true;
        }
        return false;
    }
}
