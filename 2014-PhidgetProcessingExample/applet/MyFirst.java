package myfirst;

import processing.core.PApplet;

import com.phidgets.InterfaceKitPhidget;
import com.phidgets.PhidgetException;


public class MyFirst extends PApplet {

	public void setup() {
	    this.size(100, 100);
	    InterfaceKitPhidget ifkit;
        try
        {
            ifkit = new InterfaceKitPhidget();
            ifkit.openAny();
            ifkit.waitForAttachment();

            int value = ifkit.getSensorValue(0);
            System.out.println(value);
        }
        catch (PhidgetException e)
        {
            e.printStackTrace();
        }
	}

	public void draw() {
	}
}
