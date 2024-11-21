/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Button;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
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
import java.util.ArrayList;
import java.util.List;

public class KeyboardListenerAsciiKeys
extends Panel
implements Testlet {
    int[] keysToTest = new int[]{65, 90, 48, 57};
    List<Integer> keyPressedFlag = new ArrayList<Integer>();
    List<Integer> keyReleasedFlag = new ArrayList<Integer>();
    List<Integer> keyTypedFlag = new ArrayList<Integer>();

    @Override
    public void test(TestHarness harness) {
        int key;
        int i;
        this.setBackground(Color.red);
        Frame frame = new Frame();
        Button button = new Button("xyzzy");
        button.setBackground(Color.blue);
        this.add(button);
        button.addKeyListener(new KeyListener(){

            @Override
            public void keyPressed(KeyEvent e) {
                KeyboardListenerAsciiKeys.this.keyPressedFlag.add(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyboardListenerAsciiKeys.this.keyReleasedFlag.add(e.getKeyCode());
            }

            @Override
            public void keyTyped(KeyEvent e) {
                KeyboardListenerAsciiKeys.this.keyTypedFlag.add('\u0000' + e.getKeyChar());
            }
        });
        frame.add(this);
        frame.pack();
        frame.show();
        Robot robot = harness.createRobot();
        robot.waitForIdle();
        robot.delay(1000);
        Rectangle bounds = button.getBounds();
        Point loc = frame.getLocationOnScreen();
        Insets insets = frame.getInsets();
        bounds.x += insets.left + loc.x;
        bounds.y += insets.top + loc.y;
        int checkedPixelX = bounds.x + bounds.width / 2;
        int checkedPixelY = bounds.y + bounds.height / 2;
        robot.mouseMove(checkedPixelX, checkedPixelY);
        robot.waitForIdle();
        robot.delay(250);
        for (i = 0; i < this.keysToTest.length; ++i) {
            key = this.keysToTest[i];
            robot.keyPress(key);
            robot.delay(250);
            robot.keyRelease(key);
            robot.delay(250);
        }
        robot.waitForIdle();
        robot.delay(1000);
        frame.dispose();
        for (i = 0; i < this.keysToTest.length; ++i) {
            key = this.keysToTest[i];
            harness.check(this.keyPressedFlag.contains(key));
        }
        for (i = 0; i < this.keysToTest.length; ++i) {
            key = this.keysToTest[i];
            harness.check(this.keyReleasedFlag.contains(key));
        }
        for (i = 0; i < this.keysToTest.length; ++i) {
            key = this.keysToTest[i];
            harness.check(this.keyTypedFlag.contains(key) || this.keyTypedFlag.contains(key - 65 + 97));
        }
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

