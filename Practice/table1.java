package appletexs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class table1 extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
	JButton b1;

    public table1() {
        // Frame setup
        setTitle("Table Example");
        setSize(300, 200);
        setLayout(new FlowLayout());

        // Button setup
        b1 = new JButton("Click Me");
        add(b1);

        b1.addActionListener(this); // Register event listener

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            JOptionPane.showMessageDialog(this, "Button Clicked!");
        }
    }

    public static void main(String[] args) {
        new table1(); // Launch the GUI
    }
}
