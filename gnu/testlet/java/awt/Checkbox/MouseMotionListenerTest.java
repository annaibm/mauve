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
import java.awt.event.MouseMotionListener;

public class MouseMotionListenerTest
extends Panel
implements Testlet {
    boolean mouseDraggedButton1Flag = false;
    boolean mouseDraggedButton2Flag = false;
    boolean mouseDraggedButton3Flag = false;
    boolean mouseMovedButton1Flag = false;
    boolean mouseMovedButton2Flag = false;
    boolean mouseMovedButton3Flag = false;

    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame frame = new Frame();
        Checkbox checkbox = new Checkbox("xyzzy");
        checkbox.setBackground(Color.blue);
        this.add(checkbox);
        checkbox.addMouseMotionListener(new MouseMotionListener(){

            @Override
            public void mouseDragged(MouseEvent e) {
                int modifiers2 = e.getModifiersEx();
                MouseMotionListenerTest.this.mouseDraggedButton1Flag = MouseMotionListenerTest.this.mouseDraggedButton1Flag | (modifiers2 & 0x400) != 0;
                MouseMotionListenerTest.this.mouseDraggedButton2Flag = MouseMotionListenerTest.this.mouseDraggedButton2Flag | (modifiers2 & 0x800) != 0;
                MouseMotionListenerTest.this.mouseDraggedButton3Flag = MouseMotionListenerTest.this.mouseDraggedButton3Flag | (modifiers2 & 0x1000) != 0;
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                int modifiers2 = e.getModifiersEx();
                MouseMotionListenerTest.this.mouseMovedButton1Flag = MouseMotionListenerTest.this.mouseMovedButton1Flag | (modifiers2 & 0x400) != 0;
                MouseMotionListenerTest.this.mouseMovedButton2Flag = MouseMotionListenerTest.this.mouseMovedButton2Flag | (modifiers2 & 0x800) != 0;
                MouseMotionListenerTest.this.mouseMovedButton3Flag = MouseMotionListenerTest.this.mouseMovedButton3Flag | (modifiers2 & 0x1000) != 0;
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
            robot.mouseMove(checkedPixelX - 20, checkedPixelY);
            robot.waitForIdle();
            robot.delay(250);
            robot.mousePress(mouseButton);
            robot.delay(250);
            robot.mouseMove(checkedPixelX + 20, checkedPixelY);
            robot.delay(250);
            robot.mouseRelease(mouseButton);
            robot.delay(250);
            robot.mouseMove(checkedPixelX - 20, checkedPixelY);
            robot.delay(250);
            robot.mouseMove(checkedPixelX + 20, checkedPixelY);
            robot.delay(250);
            robot.mouseMove(0, 0);
            robot.delay(250);
        }
        robot.waitForIdle();
        robot.delay(1000);
        frame.dispose();
        harness.check(this.mouseDraggedButton1Flag);
        harness.check(this.mouseDraggedButton2Flag);
        harness.check(this.mouseDraggedButton3Flag);
        harness.check(!this.mouseMovedButton1Flag);
        harness.check(!this.mouseMovedButton2Flag);
        harness.check(!this.mouseMovedButton3Flag);
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

