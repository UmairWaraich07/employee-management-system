package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    JButton view, add, update, delete;

    public Home() {

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image icon2 = icon1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel image = new JLabel(icon3);
        image.setBounds(100, 50, 1120, 630);
        add(image);

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(580, 20, 400, 40);
        image.add(heading);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 20));

        add = new JButton("Add Employee");
        add.setBounds(600, 80, 150, 40);
        add.setBackground(Color.lightGray);
        add.setForeground(Color.BLACK);
        add.setBorder(BorderFactory.createEtchedBorder());
        add.addActionListener(this);
        image.add(add);

        view = new JButton("View Employees");
        view.setBounds(770, 80, 150, 40);
        view.setBackground(Color.lightGray);
        view.setForeground(Color.BLACK);
        view.setBorder(BorderFactory.createEtchedBorder());
        view.addActionListener(this);
        image.add(view);

        update = new JButton("Update Employee");
        update.setBounds(600, 130, 150, 40);
        update.setBackground(Color.lightGray);
        update.setForeground(Color.BLACK);
        update.setBorder(BorderFactory.createEtchedBorder());
        update.addActionListener(this);
        image.add(update);

        delete = new JButton("Remove Employee");
        delete.setBounds(770, 130, 150, 40);
        delete.setBackground(Color.lightGray);
        delete.setForeground(Color.BLACK);
        delete.setBorder(BorderFactory.createEtchedBorder());
        delete.addActionListener(this);
        image.add(delete);

        setSize(1120, 630);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100, 50);
        setVisible(true);
        setTitle("HOME");
        setLayout(null);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            setVisible(false);
            new AddEmployee();

        } else if (ae.getSource() == view) {
            setVisible(false);
            new ViewEmployee();

        } else if (ae.getSource() == update) {
            setVisible(false);
            new ViewEmployee();

        } else {
            setVisible(false);
            new RemoveEmployee();
        }
    }

    public static void main(String[] args) {
        new Home();
    }
}
