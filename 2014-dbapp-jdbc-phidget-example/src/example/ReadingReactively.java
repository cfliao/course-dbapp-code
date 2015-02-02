package example;

import java.util.Date;

import com.phidgets.InterfaceKitPhidget;
import com.phidgets.event.SensorChangeEvent;
import com.phidgets.event.SensorChangeListener;

public class ReadingReactively implements SensorChangeListener
{
    private InterfaceKitPhidget ifkit;

    public ReadingReactively()
    {
        try
        {
            ifkit = new InterfaceKitPhidget();
            ifkit.addSensorChangeListener(this);
            ifkit.openAny();
            ifkit.waitForAttachment();
            ifkit.setDataRate(3, 1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public void sensorChanged(SensorChangeEvent se)
    {
        int channel = se.getIndex();
        int value = se.getValue();

        if (0 == value)
            return; // no data

        if (channel == 3) // slot 3
        {
            double temperature = (value * 0.22222) - 61.11;
            System.out.println(Utils.getRoundedString(temperature, 2));
            System.out.println(Utils.getDateString(new Date()));
        }
    }

    public static void main(String[] args)
    {
        new ReadingReactively();
    }
}
