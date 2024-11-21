/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Robot;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Robot;

public class getPixelColor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Robot r = null;
        try {
            r = new Robot();
        }
        catch (AWTException e) {
            harness.fail("caught AWT exception: " + e.getMessage());
        }
        Frame f = new Frame();
        Panel p = new Panel();
        p.setBackground(new Color(255, 0, 0));
        f.add(p);
        f.setSize(100, 100);
        f.setLocation(250, 250);
        f.show();
        r.waitForIdle();
        Color c = r.getPixelColor(300, 300);
        r.waitForIdle();
        harness.check(c.getRed() == 255 && c.getGreen() == 0 && c.getBlue() == 0);
    }
}

