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
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;

public class createScreenCapture
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
        f.setSize(500, 500);
        f.setLocation(0, 0);
        f.show();
        r.waitForIdle();
        BufferedImage screenshot = r.createScreenCapture(new Rectangle(50, 50, 100, 100));
        boolean passed = true;
        for (int i = 0; i < 100; ++i) {
            for (int j = 0; j < 100; ++j) {
                Color c = new Color(screenshot.getRGB(i, j));
                if (c.getRed() == 255 && c.getGreen() == 0 && c.getBlue() == 0) continue;
                passed = false;
            }
        }
        harness.check(passed);
    }
}

