package TableExs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TwoWindowApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Create windows without references first
                final TransactionWindow transactionWindow = new TransactionWindow();
                final LightBillWindow lightBillWindow = new LightBillWindow();

                // Set mutual references for switching
                transactionWindow.setOtherWindow(lightBillWindow);
                lightBillWindow.setOtherWindow(transactionWindow);

                // Show only one window initially
                transactionWindow.setVisible(true);
                lightBillWindow.setVisible(false);
            }
        });
    }
}

class TransactionWindow extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField t1, t2, t3;
    JButton b1, b2, b3, bSwitch;
    JTable table;
    DefaultTableModel tableModel;
    final String FILE_NAME = "data.txt";

    LightBillWindow otherWindow;

    TransactionWindow() {
        setTitle("Transaction Table");
        setSize(600, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Date");
        l2 = new JLabel("Time:");
        l3 = new JLabel("Money:");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);

        b1 = new JButton("Add");
        b2 = new JButton("Remove");
        b3 = new JButton("Exit");
        bSwitch = new JButton("Switch to Light Bill List");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        bSwitch.addActionListener(this);

        String[] columnNames = {"Date", "Time", "Money"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(550, 200));

        add(l1); add(t1);
        add(l2); add(t2);
        add(l3); add(t3);
        add(b1); add(b2); add(b3);
        add(bSwitch);
        add(scrollPane);

        loadDataFromFile();
    }

    public void setOtherWindow(LightBillWindow window) {
        this.otherWindow = window;
    }

    private String removeNonCp1252Chars(String input) {
        if (input == null) return null;
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c >= 0x20 && c <= 0xFF) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String date = removeNonCp1252Chars(t1.getText().trim());
            String time = removeNonCp1252Chars(t2.getText().trim());
            String money = removeNonCp1252Chars(t3.getText().trim());

            if (!date.equals("") && !time.equals("") && !money.equals("")) {
                tableModel.addRow(new Object[]{date, time, money});
                saveDataToFile();
                t1.setText(""); t2.setText(""); t3.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields");
            }
        } else if (ae.getSource() == b2) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
                saveDataToFile();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to remove");
            }
        } else if (ae.getSource() == b3) {
            System.exit(0);
        } else if (ae.getSource() == bSwitch) {
            this.setVisible(false);
            if (otherWindow != null) {
                otherWindow.setVisible(true);
            }
        }
    }

    private void loadDataFromFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length == 3) {
                    tableModel.addRow(new Object[]{row[0], row[1], row[2]});
                }
            }
        } catch (IOException e) {
            System.out.println("No existing file found or error reading file.");
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Error closing file reader.");
            }
        }
    }

    private void saveDataToFile() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(FILE_NAME));
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String date = removeNonCp1252Chars(tableModel.getValueAt(i, 0).toString());
                String time = removeNonCp1252Chars(tableModel.getValueAt(i, 1).toString());
                String money = removeNonCp1252Chars(tableModel.getValueAt(i, 2).toString());
                writer.println(date + "," + time + "," + money);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + e.getMessage());
        } finally {
            if (writer != null) writer.close();
        }
    }
}

class LightBillWindow extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1, b2, b3, bSwitch;
    JTable table;
    DefaultTableModel tableModel;
    final String FILE_NAME = "lightbill.txt";

    TransactionWindow otherWindow;

    LightBillWindow() {
        setTitle("Light Bill Paid List");
        setSize(400, 350);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Date");
        l2 = new JLabel("Money:");

        t1 = new JTextField(10);
        t2 = new JTextField(10);

        b1 = new JButton("Add");
        b2 = new JButton("Remove");
        b3 = new JButton("Exit");
        bSwitch = new JButton("Switch to Transaction Table");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        bSwitch.addActionListener(this);

        String[] columnNames = {"Date", "Money"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(350, 200));

        add(l1); add(t1);
        add(l2); add(t2);
        add(b1); add(b2); add(b3);
        add(bSwitch);
        add(scrollPane);

        loadDataFromFile();
    }

    public void setOtherWindow(TransactionWindow window) {
        this.otherWindow = window;
    }

    private String removeNonCp1252Chars(String input) {
        if (input == null) return null;
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c >= 0x20 && c <= 0xFF) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String date = removeNonCp1252Chars(t1.getText().trim());
            String money = removeNonCp1252Chars(t2.getText().trim());

            if (!date.equals("") && !money.equals("")) {
                tableModel.addRow(new Object[]{date, money});
                saveDataToFile();
                t1.setText(""); t2.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please fill all fields");
            }
        } else if (ae.getSource() == b2) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
                saveDataToFile();
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row to remove");
            }
        } else if (ae.getSource() == b3) {
            System.exit(0);
        } else if (ae.getSource() == bSwitch) {
            this.setVisible(false);
            if (otherWindow != null) {
                otherWindow.setVisible(true);
            }
        }
    }

    private void loadDataFromFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                if (row.length == 2) {
                    tableModel.addRow(new Object[]{row[0], row[1]});
                }
            }
        } catch (IOException e) {
            System.out.println("No existing file found or error reading file.");
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Error closing file reader.");
            }
        }
    }

    private void saveDataToFile() {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(FILE_NAME));
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String date = removeNonCp1252Chars(tableModel.getValueAt(i, 0).toString());
                String money = removeNonCp1252Chars(tableModel.getValueAt(i, 1).toString());
                writer.println(date + "," + money);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + e.getMessage());
        } finally {
            if (writer != null) writer.close();
        }
    }
}
