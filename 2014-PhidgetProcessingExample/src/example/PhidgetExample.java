package example;

import processing.core.PApplet;
import processing.core.PFont;
import edu.nccu.cs.phidget.PhidgetIfk;

public class PhidgetExample extends PApplet
{
    private static final long serialVersionUID = 1L;
    private PhidgetIfk ik;

    public void setup()
    {
        // set screen size
        size(180, 240);

        // get phidget IK started and wait up to 1s for attach
        ik = new PhidgetIfk();
        ik.waitForAttachment(1000);
        ik.setRatiometric(true);

        // set up font
        PFont myFont = createFont("arial", 10);
        textFont(myFont);
    }

    public void draw()
    {
        background(200);

        // show attach status
        if (ik.isAttached())
            fill(0, 255, 0);
        else
            fill(255, 0, 0);
        noStroke();
        ellipse(20, 20, 10, 10);

        // show serial number and version
        fill(0);
        text("Phidget Interface Kit", 40, 15);
        text("Serial: " + ik.serial(), 40, 25);
        text("Version: " + ik.version(), 40, 35);

        // display analog inputs
        for (int i = 0; i < ik.getSensorCount(); i++)
        {
            fill(0);
            text(ik.getSensorValue(i), 1, i * 20 + 50);
            stroke(0);
            line(20, i * 20 + 50, 120, i * 20 + 50);
            noStroke();
            fill(50, 20, 192);
            ellipse(ik.getSensorValue(i) / 10 + 20, i * 20 + 50, 10, 10);
        }

        // display digital inputs
        for (int i = 0; i < ik.getInputCount(); i++)
        {
            if (ik.getInputState(i))
            {
                noStroke();
                fill(0, 255, 0);
                ellipse(140, i * 20 + 50, 10, 10);
            } else
            {
                stroke(0);
                noFill();
                ellipse(140, i * 20 + 50, 10, 10);
            }
        }

        // show digital outputs
        for (int i = 0; i < ik.getOutputCount(); i++)
        {
            int xc = 160;
            int yc = i * 20 + 50;
            if (mousePressed && dist(mouseX, mouseY, xc, yc) <= 10)
            {
                noStroke();
                fill(255, 255, 0);
                ellipse(160, i * 20 + 50, 10, 10);
                ik.setOutputState(i, true);
            } else
            {
                stroke(0);
                noFill();
                ellipse(160, i * 20 + 50, 10, 10);
                ik.setOutputState(i, false);
            }
        }

        if (keyPressed)
        {
            ik.close();
            exit();
        }
    }
}
