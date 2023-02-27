package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {
    Main() {

        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");

        heading.setBounds(100, 30, 1200, 60);
        heading.setFont(new Font("serif", Font.BOLD, 50));
        heading.setForeground(new Color(30, 60, 80));

        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image icon2 = icon1.getImage().getScaledInstance(1050, 600, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(icon2);
        JLabel image = new JLabel(icon3);
        image.setBounds(65, 100, 1000, 500);
        add(image);

        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 400, 200, 50);
        image.add(clickhere);
        clickhere.setBackground(Color.black);
        clickhere.setForeground(Color.white);
        clickhere.setBorder(BorderFactory.createEtchedBorder());
        clickhere.addActionListener(this);

        add(heading);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1150, 620);
        setTitle("EMPLOYEE MANAGEMENT SYSTEM");
        setLocation(100, 50);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

        while (true) {
            heading.setVisible(false);
            try {
                Thread.sleep(600);
            } catch (Exception e) {
                e.printStackTrace();
            }
            heading.setVisible(true);
            try {
                Thread.sleep(600);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new Main(); // anonymous object
    }
}
