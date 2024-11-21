/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Robot;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTException;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class mouseMove
implements Testlet {
    int mouseX = 0;
    int mouseY = 0;

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
        b.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent event) {
                mouseMove.this.mouseX = event.getX();
                mouseMove.this.mouseY = event.getY();
            }
        });
        f.add(b);
        f.setSize(100, 100);
        f.setLocation(250, 250);
        f.show();
        r.setAutoDelay(100);
        r.mouseMove(300, 300);
        r.mousePress(16);
        r.mouseRelease(16);
        r.waitForIdle();
        Insets i = f.getInsets();
        harness.check(this.mouseX + i.left == 50 && this.mouseY + i.top == 50);
    }
}

