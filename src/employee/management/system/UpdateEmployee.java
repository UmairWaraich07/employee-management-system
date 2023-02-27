package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JButton add, back;
    JTextField tfeducation, tffname, tfemail, tfphone, tfdob, tfsalary, tfaddress, tfcnic, tfjobrole;
    String empId;

    UpdateEmployee(String empId) {
        this.empId = empId;
        setLayout(null);

        JLabel heading = new JLabel("Update Employee Details");
        heading.setBounds(280, 20, 450, 30);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 20));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 130, 130, 20);
        name.setFont(new Font("serif", Font.PLAIN, 20));
        add(name);

        JLabel lblname = new JLabel();
        lblname.setBounds(170, 130, 130, 25);
        add(lblname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 130, 130, 20);
        fname.setFont(new Font("serif", Font.PLAIN, 20));
        add(fname);

        JLabel lblfname = new JLabel();
        lblfname.setBounds(570, 130, 130, 25);
        add(lblfname);

        JLabel cnic = new JLabel("CNIC");
        cnic.setBounds(50, 200, 130, 20);
        cnic.setFont(new Font("serif", Font.PLAIN, 20));
        add(cnic);

        JLabel lblcnic = new JLabel();
        lblcnic.setBounds(170, 200, 130, 25);
        add(lblcnic);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(400, 200, 130, 20);
        salary.setFont(new Font("serif", Font.PLAIN, 20));
        add(salary);

        // TextField for salary
        tfsalary = new JTextField();
        tfsalary.setBounds(570, 200, 130, 25);
        add(tfsalary);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(50, 270, 130, 20);
        dob.setFont(new Font("serif", Font.PLAIN, 20));
        add(dob);

        JLabel lbldob = new JLabel();
        lbldob.setBounds(170, 270, 130, 20);
        add(lbldob);

        JLabel address = new JLabel("Address");
        address.setBounds(400, 270, 130, 20);
        address.setFont(new Font("serif", Font.PLAIN, 20));
        add(address);

        // TextField for address
        tfaddress = new JTextField();
        tfaddress.setBounds(570, 270, 130, 25);
        add(tfaddress);

        JLabel phone = new JLabel("Phone No.");
        phone.setBounds(50, 350, 130, 20);
        phone.setFont(new Font("serif", Font.PLAIN, 20));
        add(phone);

        // TextField for phone no
        tfphone = new JTextField();
        tfphone.setBounds(170, 350, 130, 25);
        add(tfphone);

        JLabel education = new JLabel("Education");
        education.setBounds(400, 350, 130, 20);
        education.setFont(new Font("serif", Font.PLAIN, 20));
        add(education);

        // textfield for highest education
        tfeducation = new JTextField();
        tfeducation.setBounds(570, 350, 130, 25);
        add(tfeducation);

        JLabel email = new JLabel("Email ID");
        email.setBounds(50, 420, 130, 20);
        email.setFont(new Font("serif", Font.PLAIN, 20));
        add(email);

        // TextField for email
        tfemail = new JTextField();
        tfemail.setBounds(170, 420, 130, 25);
        add(tfemail);

        JLabel jobrole = new JLabel("Job Role");
        jobrole.setBounds(400, 420, 130, 20);
        jobrole.setFont(new Font("serif", Font.PLAIN, 20));
        add(jobrole);

        tfjobrole = new JTextField();
        tfjobrole.setBounds(570, 420, 130, 25);
        add(tfjobrole);

        JLabel labelempId = new JLabel("Employee ID : ");
        labelempId.setBounds(50, 490, 130, 20);
        labelempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelempId);

        JLabel lblempId = new JLabel();
        lblempId.setBounds(170, 490, 130, 20);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);

        try {
            Connectivity conn = new Connectivity();
            String query = "SELECT * FROM employee WHERE empId = '" + empId + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                lblname.setText(rs.getString("name"));
                lblfname.setText(rs.getString("f_name"));
                tfsalary.setText(rs.getString("salary"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                lblempId.setText(rs.getString("empId"));
                tfjobrole.setText(rs.getString("jobrole"));
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                lblcnic.setText(rs.getString("cnic"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Update button
        add = new JButton("UPDATE");
        add.setBounds(250, 540, 120, 40);
        add(add);
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBorder(BorderFactory.createEtchedBorder());
        add.addActionListener(this);

        // Back Button
        back = new JButton("BACK");
        back.setBounds(450, 540, 120, 40);
        add(back);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBorder(BorderFactory.createEtchedBorder());
        back.addActionListener(this);

        // JFrame details
        setSize(800, 650);
        getContentPane().setBackground(Color.white);
        setTitle("Employee Details");
        setLocation(230, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String salary = tfsalary.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String jobrole = tfjobrole.getText();
            String education = tfeducation.getText();
            String address = tfaddress.getText();

            try {
                Connectivity conn = new Connectivity();
                String query = "UPDATE employee SET salary = '" + salary
                        + "', email = '" + email + "', address = '" + address + "',jobrole = '" + jobrole
                        + "', phone = '" + phone
                        + "',education = '" + education + "' WHERE empId = '" + empId + "'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details updated successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            setVisible(false);
            new Home();
        }
    }

    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
