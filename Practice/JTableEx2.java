package appletexs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class JTableEx2 extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2, b3;
    JTable table;
    DefaultTableModel tableModel;
    final String FILE_NAME = "data.txt";

    JTableEx2() {
        setTitle("Student Table Example");
        setSize(600, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Roll No:");
        l2 = new JLabel("Name:");
        l3 = new JLabel("Per:");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);

        b1 = new JButton("Add");
        b2 = new JButton("Remove");
        b3 = new JButton("Exit");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        // Table setup
        String[] columnNames = {"Roll No", "Name", "Percentage"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(550, 200));

        // Add components to frame
        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(b1); add(b2); add(b3);
        add(scrollPane);

        // Load data from file
        loadDataFromFile();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String roll = t1.getText().trim();
            String name = t2.getText().trim();
            String per = t3.getText().trim();

            if (!roll.isEmpty() && !name.isEmpty() && !per.isEmpty()) {
                tableModel.addRow(new Object[]{roll, name, per});
                saveDataToFile(); // Save immediately
                t1.setText(""); t2.setText(""); t3.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields");
            }

        } else if (ae.getSource() == b2) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
                saveDataToFile(); // Update file
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to remove");
            }

        } else if (ae.getSource() == b3) {
            System.exit(0);
        }
    }

    private void loadDataFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length == 3) {
                    tableModel.addRow(new Object[]{row[0], row[1], row[2]});
                }
            }
        } catch (IOException e) {
            System.out.println("No existing file found or error reading file.");
        }
    }

    private void saveDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                writer.println(tableModel.getValueAt(i, 0) + "," +
                               tableModel.getValueAt(i, 1) + "," +
                               tableModel.getValueAt(i, 2));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new JTableEx();
    }
}
