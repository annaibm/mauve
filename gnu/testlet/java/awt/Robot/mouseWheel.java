/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Robot;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTException;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class mouseWheel
implements Testlet {
    int mouseWheelUpCount = 0;
    int mouseWheelDownCount = 0;

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
        Button b = new Button("test");
        b.addMouseWheelListener(new MouseWheelListener(){

            @Override
            public void mouseWheelMoved(MouseWheelEvent event) {
                int wheelRotation = event.getWheelRotation();
                if (wheelRotation < 0) {
                    mouseWheel.this.mouseWheelUpCount += wheelRotation;
                } else {
                    mouseWheel.this.mouseWheelDownCount += wheelRotation;
                }
            }
        });
        f.add(b);
        f.setSize(100, 100);
        f.setLocation(250, 250);
        f.show();
        r.setAutoDelay(100);
        r.mouseMove(300, 300);
        r.mouseWheel(-4);
        r.mouseWheel(5);
        r.mouseWheel(-1);
        r.mouseWheel(3);
        r.mouseWheel(2);
        r.mouseWheel(-3);
        r.waitForIdle();
        harness.check(this.mouseWheelUpCount == -8);
        harness.check(this.mouseWheelDownCount == 10);
    }
}

