package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample1
{

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {
        // Step 1: load JDBC driver
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        // Step 2: get connection
        String url = "jdbc:mysql://localhost:3306/company?user=root&password=nccutest";
        Connection connection = DriverManager.getConnection(url);

        // Step 3: �إ�Statement����
        Statement stmt = connection.createStatement();

        // Step 4: �USQL
        // INSERT INTO department VALUES('Sales2',9,'123456789','2014-12-11')
        // UPDATE department SET dname = 'Sales-2' WHERE Dnumber=9
        // DELETE FROM department WHERE Dnumber=9
        int result = stmt.executeUpdate("");

        // Step 5: �B�z���G
        System.out.println(result + "����s���\");

    }

}
