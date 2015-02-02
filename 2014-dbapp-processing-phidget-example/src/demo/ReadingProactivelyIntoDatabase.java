package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.util.Date;

import com.phidgets.InterfaceKitPhidget;
import com.phidgets.PhidgetException;

public class ReadingProactivelyIntoDatabase
{

    public static void main(String[] args) throws PhidgetException, InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {
        // prepare JDBC
        
        // Step 1: load JDBC driver
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        // Step 2: get connection
        String url = "jdbc:mysql://localhost:3306/temperature?user=root&password=nccutest";
        Connection connection = DriverManager.getConnection(url);

        // prepare Phidget
        InterfaceKitPhidget ifkit = new InterfaceKitPhidget();
        ifkit.openAny();
        ifkit.waitForAttachment();
        
        while (true)
        {
            int value = ifkit.getSensorValue(0);
            double temperature = (value * 0.22222) - 61.11;
            
            System.out.println(Utils.getRoundedString(temperature, 2));

            System.out.println(Utils.getDateString(new Date()));

            // Step 3: 建立Statement物件
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO temperature VALUES(NULL,?,?)");
            pstmt.setDouble(1, temperature);
            pstmt.setTimestamp(2, new java.sql.Timestamp(new Date().getTime()));
            
            // Step 4: 下SQL
            int result =  pstmt.executeUpdate();
            
            // Step 5: 處理結果
            System.out.println(result + "筆更新成功");
            
            Thread.sleep(5000);
        }
    }

}
