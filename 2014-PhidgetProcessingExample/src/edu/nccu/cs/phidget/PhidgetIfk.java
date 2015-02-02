package edu.nccu.cs.phidget;

import com.phidgets.InterfaceKitPhidget;

public class PhidgetIfk
{
    InterfaceKitPhidget ik;

    // constructors
    // open first available interface kit
    public PhidgetIfk()
    {
        try
        {
            ik = new InterfaceKitPhidget();
            ik.openAny();
        }
        catch (Exception e)
        {
        }
    }

    // close the ik
    public void close()
    {
        try
        {
            ik.close();
        }
        catch (Exception e)
        {
        }
    }

    // check if interface kit is attached
    public boolean isAttached()
    {
        boolean result;

        try
        {
            result = ik.isAttached();
        }
        catch (Exception e)
        {
            result = false;
        }
        return result;
    }

    // wait for phidget to attach - with time out
    public void waitForAttachment(int timeout)
    {
        try
        {
            ik.waitForAttachment(timeout);
        }
        catch (Exception e)
        {
        }
    }

    // sait for phidget to attach - indefinitely
    public void waitForAttachment()
    {
        try
        {
            ik.waitForAttachment();
        }
        catch (Exception e)
        {
        }
    }

    // get serial number of attached phidget, return -1 if not attached
    public int serial()
    {
        int s;

        try
        {
            s = ik.getSerialNumber();
        }
        catch (Exception e)
        {
            s = -1;
        }
        return s;
    }

    // get device version
    public int version()
    {
        int v;

        try
        {
            v = ik.getDeviceVersion();
        }
        catch (Exception e)
        {
            v = -1;
        }
        return v;
    }

    // set/reset ratiometric mode
    public void setRatiometric(boolean state)
    {
        try
        {
            ik.setRatiometric(state);
        }
        catch (Exception e)
        {
        }
    }

    // get numaber of analog sensors
    public int getSensorCount()
    {
        int count;
        try
        {
            count = ik.getSensorCount();
            return count;
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    // get value for analog sensor
    public int getSensorValue(int index)
    {
        int v;
        try
        {
            v = ik.getSensorValue(index);
            return v;
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    // get the number of digital inputs
    public int getInputCount()
    {
        int count;
        try
        {
            count = ik.getInputCount();
            return count;
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    // get digital input
    public boolean getInputState(int index)
    {
        boolean state;
        try
        {
            state = ik.getInputState(index);
            return state;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    // get the number of digital outputs
    public int getOutputCount()
    {
        int count;
        try
        {
            count = ik.getOutputCount();
            return count;
        }
        catch (Exception e)
        {
            return 0;
        }
    }

    // set digital outputs
    public void setOutputState(int index, boolean state)
    {
        try
        {
            ik.setOutputState(index, state);
        }
        catch (Exception e)
        {
        }
    }

}
