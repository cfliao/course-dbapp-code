package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest
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
        ResultSet rs = stmt.executeQuery("SELECT count(*) FROM Employee");

        // Step 5: �B�z���G
        rs.next();
        System.out.println(rs.getString("count(*)"));
    }
}
