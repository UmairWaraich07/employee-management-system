package employee.management.system;

import java.sql.*;

public class Connectivity {
    Connection c;
    Statement s;

    public Connectivity() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "Umair@107");
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
