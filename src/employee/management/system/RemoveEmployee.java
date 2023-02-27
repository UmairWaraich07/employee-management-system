package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice cempId;
    JButton delete, back;

    RemoveEmployee() {

        setLayout(null);
        getContentPane().setBackground(Color.white);

        JLabel heading = new JLabel("Employee ID");
        heading.setBounds(50, 50, 100, 30);
        heading.setFont(new Font("tahoma", Font.BOLD, 15));
        add(heading);

        cempId = new Choice();
        cempId.setBounds(200, 50, 150, 30);
        add(cempId);
        try {
            Connectivity conn = new Connectivity();
            String query = "SELECT * FROM employee ";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                cempId.add(rs.getString("empId"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelname = new JLabel("Name : ");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);

        JLabel lblname = new JLabel();
        lblname.setBounds(150, 100, 100, 30);
        add(lblname);

        JLabel labelphone = new JLabel("Phone : ");
        labelphone.setBounds(50, 170, 100, 30);
        add(labelphone);

        JLabel lblphone = new JLabel();
        lblphone.setBounds(150, 170, 100, 30);
        add(lblphone);

        JLabel labelemail = new JLabel("Email : ");
        labelemail.setBounds(50, 240, 100, 30);
        add(labelemail);

        JLabel lblemail = new JLabel();
        lblemail.setBounds(150, 240, 100, 30);
        add(lblemail);

        try {
            Connectivity conn = new Connectivity();
            String query = "SELECT * FROM employee WHERE empId = '" + cempId.getSelectedItem() + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblemail.setText(rs.getString("email"));
                lblphone.setText(rs.getString("phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        cempId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Connectivity conn = new Connectivity();
                    String query = "SELECT * FROM employee WHERE empId = '" + cempId.getSelectedItem() + "'";
                    ResultSet rs = conn.s.executeQuery(query);
                    while (rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblemail.setText(rs.getString("email"));
                        lblphone.setText(rs.getString("phone"));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

        // delete Button
        delete = new JButton("Delete");
        delete.setBounds(100, 300, 100, 30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.white);
        delete.setBorder(BorderFactory.createEtchedBorder());
        delete.addActionListener(this);
        add(delete);

        // back Button
        back = new JButton("Back");
        back.setBounds(230, 300, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBorder(BorderFactory.createEtchedBorder());
        back.addActionListener(this);
        add(back);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image icon2 = icon1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel image = new JLabel(icon3);
        image.setBounds(350, 20, 500, 350);
        add(image);

        setSize(900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(185, 80);
        setTitle("Remove Employee");
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Connectivity conn = new Connectivity();
                String query = "DELETE FROM employee WHERE empId = '" + cempId.getSelectedItem() + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Information deleted successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Home();
        }

    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }

}
