package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import processing.core.PApplet;

public class ProcessingTemperature extends PApplet
{

    private static final long serialVersionUID = 1L;

    private Statement stmt;

    public void setup()
    {
        size(600, 400);
        // Create database connection
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Step 2: get connection
            String url = "jdbc:mysql://localhost:3306/temperature?user=root&password=nccutest";
            Connection connection = DriverManager.getConnection(url);

            // Step 3: 建立Statement物件
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM temperature");

            //calculate rwo counts
            rs.last();
            int size = rs.getRow();
            //reset
            rs.beforeFirst();
            
            // left margin
            float x = (float) (width * 0.03);
            float y = (float) (height * 0.9);
            
            float delta = (float) (width * 0.95 / size);
            float w = (float) (delta * 0.7);
            background(255);
            textSize(12);
            int i = 0;

            while (rs.next())
            {
                float h = map(rs.getFloat("t_value"), 17, 25, 0, height);
                fill(0xFF, 0x95, 0xCA);
                rect(x, y - h, w, h);
                fill(0);
                text(rs.getString("id"), x, y + 10);
                text(Utils.getRoundedString(rs.getDouble("t_value"), 1), x, y - h);
                x = x + delta;
                i++;
                println(rs.getInt("id"));
                println(rs.getDouble("t_value"));
                println(rs.getTimestamp("t_timestamp"));
                println("---------");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void draw()
    {
    }
}
