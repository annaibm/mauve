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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerTest
extends Panel
implements Testlet {
    boolean mouseClickedButton1Flag = false;
    boolean mouseClickedButton2Flag = false;
    boolean mouseClickedButton3Flag = false;
    boolean mousePressedButton1Flag = false;
    boolean mousePressedButton2Flag = false;
    boolean mousePressedButton3Flag = false;
    boolean mouseReleasedButton1Flag = false;
    boolean mouseReleasedButton2Flag = false;
    boolean mouseReleasedButton3Flag = false;
    boolean mouseEnteredFlag = false;
    boolean mouseExitedFlag = false;

    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame frame = new Frame();
        Checkbox checkbox = new Checkbox("xyzzy");
        checkbox.setBackground(Color.blue);
        this.add(checkbox);
        checkbox.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                switch (e.getButton()) {
                    case 1: {
                        MouseListenerTest.this.mouseClickedButton1Flag = true;
                        break;
                    }
                    case 2: {
                        MouseListenerTest.this.mouseClickedButton2Flag = true;
                        break;
                    }
                    case 3: {
                        MouseListenerTest.this.mouseClickedButton3Flag = true;
                        break;
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                MouseListenerTest.this.mouseEnteredFlag = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                MouseListenerTest.this.mouseExitedFlag = true;
            }

            @Override
            public void mousePressed(MouseEvent e) {
                switch (e.getButton()) {
                    case 1: {
                        MouseListenerTest.this.mousePressedButton1Flag = true;
                        break;
                    }
                    case 2: {
                        MouseListenerTest.this.mousePressedButton2Flag = true;
                        break;
                    }
                    case 3: {
                        MouseListenerTest.this.mousePressedButton3Flag = true;
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                switch (e.getButton()) {
                    case 1: {
                        MouseListenerTest.this.mouseReleasedButton1Flag = true;
                        break;
                    }
                    case 2: {
                        MouseListenerTest.this.mouseReleasedButton2Flag = true;
                        break;
                    }
                    case 3: {
                        MouseListenerTest.this.mouseReleasedButton3Flag = true;
                        break;
                    }
                }
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
        Integer[] integerArray = new Integer[]{16, 8, 4};
        int n = integerArray.length;
        for (int j = 0; j < n; ++j) {
            int mouseButton = integerArray[j];
            robot.mouseMove(0, 0);
            robot.waitForIdle();
            robot.mouseMove(checkedPixelX, checkedPixelY);
            robot.waitForIdle();
            robot.delay(250);
            robot.mousePress(mouseButton);
            robot.delay(250);
            robot.mouseRelease(mouseButton);
            robot.delay(250);
            robot.mouseMove(0, 0);
            robot.delay(250);
        }
        robot.waitForIdle();
        robot.delay(1000);
        frame.dispose();
        harness.check(this.mouseClickedButton1Flag);
        harness.check(this.mouseClickedButton2Flag);
        harness.check(this.mouseClickedButton3Flag);
        harness.check(this.mousePressedButton1Flag);
        harness.check(this.mousePressedButton2Flag);
        harness.check(this.mousePressedButton3Flag);
        harness.check(this.mouseReleasedButton1Flag);
        harness.check(this.mouseReleasedButton2Flag);
        harness.check(this.mouseReleasedButton3Flag);
        harness.check(this.mouseEnteredFlag);
        harness.check(this.mouseExitedFlag);
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

