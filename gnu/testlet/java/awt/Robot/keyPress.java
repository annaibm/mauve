/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Robot;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTException;
import java.awt.Frame;
import java.awt.Robot;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyPress
implements Testlet {
    char pressChar = '\u0000';
    char releaseChar = '\u0000';
    int pressCount = 0;
    int releaseCount = 0;

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
        TextField tf = new TextField();
        tf.addKeyListener(new KeyAdapter(){

            @Override
            public void keyPressed(KeyEvent event) {
                keyPress.this.pressChar = event.getKeyChar();
                ++keyPress.this.pressCount;
            }

            @Override
            public void keyReleased(KeyEvent event) {
                keyPress.this.releaseChar = event.getKeyChar();
                ++keyPress.this.releaseCount;
            }
        });
        f.add(tf);
        f.setSize(100, 100);
        f.setLocation(250, 250);
        f.show();
        r.setAutoDelay(100);
        r.mouseMove(300, 300);
        r.mousePress(16);
        r.mouseRelease(16);
        r.keyPress(65);
        r.keyRelease(65);
        r.waitForIdle();
        harness.check(this.pressChar == 'a');
        harness.check(this.pressCount == 1);
    }
}

