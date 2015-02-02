package example;

import java.util.Date;

import com.phidgets.InterfaceKitPhidget;
import com.phidgets.PhidgetException;

public class ReadingProactively
{

    public static void main(String[] args) throws PhidgetException, InterruptedException
    {
        InterfaceKitPhidget ifkit = new InterfaceKitPhidget();
        ifkit.openAny();
        ifkit.waitForAttachment();
        while (true)
        {
            int value = ifkit.getSensorValue(3);
            double temperature = (value * 0.22222) - 61.11;
            
            System.out.println(Utils.getRoundedString(temperature, 2));

            System.out.println(Utils.getDateString(new Date()));

            Thread.sleep(5000);
        }
    }

}
