package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import java.util.Random;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    Random rand = new Random();
    int number = rand.nextInt(999999);

    JButton add, back;
    JTextField tfname, tffname, tfemail, tfphone, tfdob, tfsalary, tfaddress, tfcnic, tfjobrole;
    JDateChooser dcdob;
    JComboBox cbeducation;
    JLabel idnumber;

    AddEmployee() {
        setLayout(null);

        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(280, 20, 450, 30);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 20));
        add(heading);

        JLabel name = new JLabel("Name");
        name.setBounds(50, 130, 130, 20);
        name.setFont(new Font("serif", Font.PLAIN, 20));
        add(name);

        // textfield for name
        tfname = new JTextField();
        tfname.setBounds(170, 130, 130, 25);
        add(tfname);

        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400, 130, 130, 20);
        fname.setFont(new Font("serif", Font.PLAIN, 20));
        add(fname);

        // TextField for father name
        tffname = new JTextField();
        tffname.setBounds(570, 130, 130, 25);
        add(tffname);

        JLabel cnic = new JLabel("CNIC");
        cnic.setBounds(50, 200, 130, 20);
        cnic.setFont(new Font("serif", Font.PLAIN, 20));
        add(cnic);

        // TextField for cnic
        tfcnic = new JTextField();
        tfcnic.setBounds(170, 200, 130, 25);
        add(tfcnic);

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

        // to choose date of birth
        dcdob = new JDateChooser();
        dcdob.setBounds(170, 270, 130, 20);
        add(dcdob);

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

        // combobox to select education
        String course[] = { "BS(AI)", "BS(CS)", "BS(SE)", "BSc", "BA", "BBA", "BS(IS)", "PhD", "BS(ENG)", "other" };
        cbeducation = new JComboBox(course);
        cbeducation.setBounds(570, 350, 130, 25);
        add(cbeducation);

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

        JLabel empId = new JLabel("Employee ID : ");
        empId.setBounds(50, 490, 130, 20);
        empId.setFont(new Font("serif", Font.PLAIN, 20));
        add(empId);

        idnumber = new JLabel("" + number);
        idnumber.setBounds(170, 490, 130, 20);
        idnumber.setFont(new Font("serif", Font.PLAIN, 20));
        add(idnumber);

        // Add button
        add = new JButton("ADD");
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
            String name = tfname.getText();
            String fname = tffname.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String salary = tfsalary.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String jobrole = tfjobrole.getText();
            String cnic = tfcnic.getText();
            String education = (String) cbeducation.getSelectedItem();
            String address = tfaddress.getText();
            String empId = idnumber.getText();

            try {
                Connectivity conn = new Connectivity();
                String query = "INSERT INTO employee VALUES ('" + empId + "','" + name + "','" + fname + "','" + salary
                        + "','" + email + "','" + dob + "','" + cnic + "','" + address + "','" + jobrole + "','" + phone
                        + "','" + education + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
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
        new AddEmployee();
    }
}
