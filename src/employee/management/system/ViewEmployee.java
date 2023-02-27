package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;
    JButton search, print, update, back;
    Choice cEmpId;

    public ViewEmployee() {

        setLayout(null);

        table = new JTable();
        try {
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("SELECT * FROM employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 900, 650);
        add(jsp);

        JLabel lblsearch = new JLabel("Search by Employee ID: ");
        lblsearch.setBounds(20, 20, 150, 20);
        add(lblsearch);

        // a bar down using choice class
        cEmpId = new Choice();
        cEmpId.setBounds(180, 20, 150, 20);
        add(cEmpId);

        try {
            Connectivity c = new Connectivity();
            ResultSet rs = c.s.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                cEmpId.add(rs.getString("empId"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // search Button
        search = new JButton("Search");
        search.setBounds(20, 55, 80, 25);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        search.setBorder(BorderFactory.createEtchedBorder());
        search.addActionListener(this);
        add(search);

        // print Button
        print = new JButton("Print");
        print.setBounds(110, 55, 80, 25);
        print.setBackground(Color.black);
        print.setForeground(Color.white);
        print.setBorder(BorderFactory.createEtchedBorder());
        print.addActionListener(this);
        add(print);

        // update Button
        update = new JButton("Update");
        update.setBounds(200, 55, 80, 25);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBorder(BorderFactory.createEtchedBorder());
        update.addActionListener(this);
        add(update);

        // back Button
        back = new JButton("Back");
        back.setBounds(290, 55, 80, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBorder(BorderFactory.createEtchedBorder());
        back.addActionListener(this);
        add(back);

        // JFrame details
        setSize(900, 650);
        getContentPane().setBackground(Color.white);
        setTitle("Employees Details");
        setLocation(230, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "SELECT * FROM employee WHERE empId = '" + cEmpId.getSelectedItem() + "'";
            try {
                Connectivity conn = new Connectivity();
                ResultSet rs = conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == print) {
            try {
                table.print();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(cEmpId.getSelectedItem());

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new ViewEmployee();

    }
}
