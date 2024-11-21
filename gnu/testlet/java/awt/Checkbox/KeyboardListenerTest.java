/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Checkbox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListenerTest
extends Panel
implements Testlet {
    boolean keyPressedFlag = false;
    boolean keyReleasedFlag = false;
    boolean keyTypedFlag = false;

    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame frame = new Frame();
        Checkbox checkbox = new Checkbox("xyzzy");
        checkbox.setBackground(Color.blue);
        this.add(checkbox);
        checkbox.addKeyListener(new KeyListener(){

            @Override
            public void keyPressed(KeyEvent e) {
                KeyboardListenerTest.this.keyPressedFlag = true;
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyboardListenerTest.this.keyReleasedFlag = true;
            }

            @Override
            public void keyTyped(KeyEvent e) {
                KeyboardListenerTest.this.keyTypedFlag = true;
            }
        });
        frame.add(this);
        frame.pack();
        frame.show();
        Robot robot = harness.createRobot();
        robot.waitForIdle();
        robot.delay(1000);
        Rectangle bounds = checkbox.getBounds();
        Point loc = frame.getLocationOnScreen();
        Insets i = frame.getInsets();
        bounds.x += i.left + loc.x;
        bounds.y += i.top + loc.y;
        int checkedPixelX = bounds.x + bounds.width / 2;
        int checkedPixelY = bounds.y + bounds.height / 2;
        robot.mouseMove(checkedPixelX, checkedPixelY);
        robot.waitForIdle();
        robot.delay(250);
        robot.keyPress(65);
        robot.delay(250);
        robot.keyRelease(65);
        robot.waitForIdle();
        robot.delay(1000);
        frame.dispose();
        harness.check(this.keyPressedFlag);
        harness.check(this.keyReleasedFlag);
        harness.check(this.keyTypedFlag);
    }

    @Override
    public void paint(Graphics g) {
        Image offScr = this.createImage(this.getSize().width, this.getSize().height);
        Graphics offG = offScr.getGraphics();
        offG.setClip(0, 0, this.getSize().width, this.getSize().height);
        super.paint(offG);
        g.drawImage(offScr, 0, 0, null);
        offG.dispose();
    }
}

