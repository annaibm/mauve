/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Component;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class clickModifiers
implements Testlet {
    int modifiers = 0;

    @Override
    public void test(TestHarness harness) {
        Robot r = harness.createRobot();
        int x = 100;
        int y = 100;
        int width = 100;
        int height = 100;
        clickModifiersFrame f = new clickModifiersFrame();
        f.setLocation(x, y);
        f.setSize(width, height);
        f.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e) {
                clickModifiers.this.modifiers = e.getModifiers();
            }
        });
        r.setAutoDelay(100);
        r.setAutoWaitForIdle(true);
        f.show();
        r.mouseMove(x + width / 2, y + height / 2);
        r.mousePress(16);
        r.mouseRelease(16);
        harness.check(this.modifiers == 16);
        r.mousePress(8);
        r.mouseRelease(8);
        harness.check(this.modifiers == 8);
        r.mousePress(4);
        r.mouseRelease(4);
        harness.check(this.modifiers == 4);
    }

    class clickModifiersFrame
    extends Frame {
        clickModifiersFrame() {
        }
    }
}

