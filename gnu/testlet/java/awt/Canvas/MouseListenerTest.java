/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Canvas;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;
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
    boolean mouseClickedCanvas1Flag = false;
    boolean mouseClickedCanvas2Flag = false;
    boolean mouseClickedCanvas3Flag = false;
    boolean mousePressedCanvas1Flag = false;
    boolean mousePressedCanvas2Flag = false;
    boolean mousePressedCanvas3Flag = false;
    boolean mouseReleasedCanvas1Flag = false;
    boolean mouseReleasedCanvas2Flag = false;
    boolean mouseReleasedCanvas3Flag = false;
    boolean mouseEnteredFlag = false;
    boolean mouseExitedFlag = false;

    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame frame = new Frame();
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.blue);
        canvas.setSize(100, 100);
        this.add(canvas);
        canvas.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                switch (e.getButton()) {
                    case 1: {
                        MouseListenerTest.this.mouseClickedCanvas1Flag = true;
                        break;
                    }
                    case 2: {
                        MouseListenerTest.this.mouseClickedCanvas2Flag = true;
                        break;
                    }
                    case 3: {
                        MouseListenerTest.this.mouseClickedCanvas3Flag = true;
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
                        MouseListenerTest.this.mousePressedCanvas1Flag = true;
                        break;
                    }
                    case 2: {
                        MouseListenerTest.this.mousePressedCanvas2Flag = true;
                        break;
                    }
                    case 3: {
                        MouseListenerTest.this.mousePressedCanvas3Flag = true;
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                switch (e.getButton()) {
                    case 1: {
                        MouseListenerTest.this.mouseReleasedCanvas1Flag = true;
                        break;
                    }
                    case 2: {
                        MouseListenerTest.this.mouseReleasedCanvas2Flag = true;
                        break;
                    }
                    case 3: {
                        MouseListenerTest.this.mouseReleasedCanvas3Flag = true;
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
        Rectangle bounds = canvas.getBounds();
        Point loc = frame.getLocationOnScreen();
        Insets i = frame.getInsets();
        bounds.x += i.left + loc.x;
        bounds.y += i.top + loc.y;
        int checkedPixelX = bounds.x + bounds.width / 2;
        int checkedPixelY = bounds.y + bounds.height / 2;
        Integer[] integerArray = new Integer[]{16, 8, 4};
        int n = integerArray.length;
        for (int j = 0; j < n; ++j) {
            int mouseCanvas = integerArray[j];
            robot.mouseMove(0, 0);
            robot.waitForIdle();
            robot.mouseMove(checkedPixelX, checkedPixelY);
            robot.waitForIdle();
            robot.delay(250);
            robot.mousePress(mouseCanvas);
            robot.delay(250);
            robot.mouseRelease(mouseCanvas);
            robot.delay(250);
            robot.mouseMove(0, 0);
            robot.delay(250);
        }
        robot.waitForIdle();
        robot.delay(1000);
        frame.dispose();
        harness.check(this.mouseClickedCanvas1Flag);
        harness.check(this.mouseClickedCanvas2Flag);
        harness.check(this.mouseClickedCanvas3Flag);
        harness.check(this.mousePressedCanvas1Flag);
        harness.check(this.mousePressedCanvas2Flag);
        harness.check(this.mousePressedCanvas3Flag);
        harness.check(this.mouseReleasedCanvas1Flag);
        harness.check(this.mouseReleasedCanvas2Flag);
        harness.check(this.mouseReleasedCanvas3Flag);
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

