package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField tfusername, tfpassword;

    Login() {

        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel lbluserName = new JLabel("Username");
        lbluserName.setBounds(40, 20, 100, 30);
        add(lbluserName);

        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 130, 30);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40, 70, 100, 30);
        add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(130, 70, 130, 30);
        add(tfpassword);

        JButton login = new JButton("LOGIN");
        login.setBounds(130, 140, 130, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.setBorder(BorderFactory.createEtchedBorder());
        login.addActionListener(this);
        add(login);

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image icon2 = icon1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel image = new JLabel(icon3);
        image.setBounds(360, 0, 200, 200);
        add(image);

        setSize(600, 300);
        setVisible(true);
        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("LOGIN PAGE");

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String username = tfusername.getText();
            String password = tfpassword.getText();

            Connectivity c = new Connectivity();
            String query = "SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'";

            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();

    }
}
