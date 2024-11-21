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
import java.awt.event.MouseMotionListener;

public class MouseMotionListenerTest
extends Panel
implements Testlet {
    boolean mouseDraggedCanvas1Flag = false;
    boolean mouseDraggedCanvas2Flag = false;
    boolean mouseDraggedCanvas3Flag = false;
    boolean mouseMovedCanvas1Flag = false;
    boolean mouseMovedCanvas2Flag = false;
    boolean mouseMovedCanvas3Flag = false;

    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame frame = new Frame();
        Canvas canvas = new Canvas();
        canvas.setBackground(Color.blue);
        canvas.setSize(100, 100);
        this.add(canvas);
        canvas.addMouseMotionListener(new MouseMotionListener(){

            @Override
            public void mouseDragged(MouseEvent e) {
                int modifiers2 = e.getModifiersEx();
                MouseMotionListenerTest.this.mouseDraggedCanvas1Flag = MouseMotionListenerTest.this.mouseDraggedCanvas1Flag | (modifiers2 & 0x400) != 0;
                MouseMotionListenerTest.this.mouseDraggedCanvas2Flag = MouseMotionListenerTest.this.mouseDraggedCanvas2Flag | (modifiers2 & 0x800) != 0;
                MouseMotionListenerTest.this.mouseDraggedCanvas3Flag = MouseMotionListenerTest.this.mouseDraggedCanvas3Flag | (modifiers2 & 0x1000) != 0;
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                int modifiers2 = e.getModifiersEx();
                MouseMotionListenerTest.this.mouseMovedCanvas1Flag = MouseMotionListenerTest.this.mouseMovedCanvas1Flag | (modifiers2 & 0x400) != 0;
                MouseMotionListenerTest.this.mouseMovedCanvas2Flag = MouseMotionListenerTest.this.mouseMovedCanvas2Flag | (modifiers2 & 0x800) != 0;
                MouseMotionListenerTest.this.mouseMovedCanvas3Flag = MouseMotionListenerTest.this.mouseMovedCanvas3Flag | (modifiers2 & 0x1000) != 0;
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
            robot.mouseMove(checkedPixelX - 20, checkedPixelY);
            robot.waitForIdle();
            robot.delay(250);
            robot.mousePress(mouseCanvas);
            robot.delay(250);
            robot.mouseMove(checkedPixelX + 20, checkedPixelY);
            robot.delay(250);
            robot.mouseRelease(mouseCanvas);
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
        harness.check(this.mouseDraggedCanvas1Flag);
        harness.check(this.mouseDraggedCanvas2Flag);
        harness.check(this.mouseDraggedCanvas3Flag);
        harness.check(!this.mouseMovedCanvas1Flag);
        harness.check(!this.mouseMovedCanvas2Flag);
        harness.check(!this.mouseMovedCanvas3Flag);
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

