package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Statement;
import java.util.Date;

import com.phidgets.InterfaceKitPhidget;
import com.phidgets.PhidgetException;

public class Practice3
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
            int value = ifkit.getSensorValue(1);// TODO: change this line! confirm that the humidity sensor is attached to the right channel
            double humidity = 0; // TODO: change this line!
            
            System.out.println(Utils.getRoundedString(humidity, 2));

            System.out.println(Utils.getDateString(new Date()));

            // TODO: Refer to ReadingProactivelyIntoDatabase.java, add prepared statments here
            
            
            // TODO: Uncomment the following line after you finishing the previous step
            // int result =  pstmt.executeUpdate();
            
            // TODO: uncomment the following line after you finishing the previous step
            //System.out.println(result + "Updated!");
            
            Thread.sleep(5000);
        }
    }

}
