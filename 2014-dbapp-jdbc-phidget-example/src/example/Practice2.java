package example;

import java.util.Date;

import com.phidgets.InterfaceKitPhidget;
import com.phidgets.PhidgetException;

public class Practice2
{
    public static void main(String[] args) throws PhidgetException, InterruptedException
    {
        InterfaceKitPhidget ifkit = new InterfaceKitPhidget();
        ifkit.openAny();
        ifkit.waitForAttachment();
        //your code starts here
    }
}
