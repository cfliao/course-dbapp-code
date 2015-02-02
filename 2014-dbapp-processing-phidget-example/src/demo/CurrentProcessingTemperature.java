package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import processing.core.PApplet;

public class CurrentProcessingTemperature extends PApplet
{

    private static final long serialVersionUID = 1L;

    private Statement stmt;

    private Connection connection;

    public void setup()
    {
        size(600, 400);
        // Create database connection
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Step 2: get connection
            String url = "jdbc:mysql://localhost:3306/temperature?user=root&password=nccutest";
            connection = DriverManager.getConnection(url);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void draw()
    {
        try
        {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM temperature ORDER BY t_timestamp DESC LIMIT 5");

            // left margin
            float x = (float) (width * 0.1);
            float y = (float) (height * 0.9);

            float delta = (float) (width * 0.9 / 5);
            float w = (float) (delta * 0.8);
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
                if (rs.isLast())
                    text("Most recent measurement: " + rs.getTimestamp("t_timestamp"), 100, 30);
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
