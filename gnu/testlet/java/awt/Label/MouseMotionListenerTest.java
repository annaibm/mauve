/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Label;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionListenerTest
extends Panel
implements Testlet {
    private static final long serialVersionUID = 4009815071982906794L;
    private boolean mouseDraggedLabel1Flag = false;
    private boolean mouseDraggedLabel2Flag = false;
    private boolean mouseDraggedLabel3Flag = false;
    private boolean mouseMovedLabel1Flag = false;
    private boolean mouseMovedLabel2Flag = false;
    private boolean mouseMovedLabel3Flag = false;

    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame frame = new Frame();
        Label label = new Label("The quick brown fox jumps over the lazy dog.");
        label.setBackground(Color.blue);
        this.add(label);
        label.addMouseMotionListener(new MouseMotionListener(){

            @Override
            public void mouseDragged(MouseEvent e) {
                int modifiers2 = e.getModifiersEx();
                MouseMotionListenerTest.this.setMouseDraggedLabel1Flag(MouseMotionListenerTest.this.isMouseDraggedLabel1Flag() | (modifiers2 & 0x400) != 0);
                MouseMotionListenerTest.this.setMouseDraggedLabel2Flag(MouseMotionListenerTest.this.isMouseDraggedLabel2Flag() | (modifiers2 & 0x800) != 0);
                MouseMotionListenerTest.this.setMouseDraggedLabel3Flag(MouseMotionListenerTest.this.isMouseDraggedLabel3Flag() | (modifiers2 & 0x1000) != 0);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                int modifiers2 = e.getModifiersEx();
                MouseMotionListenerTest.this.setMouseMovedLabel1Flag(MouseMotionListenerTest.this.isMouseMovedLabel1Flag() | (modifiers2 & 0x400) != 0);
                MouseMotionListenerTest.this.setMouseMovedLabel2Flag(MouseMotionListenerTest.this.isMouseMovedLabel2Flag() | (modifiers2 & 0x800) != 0);
                MouseMotionListenerTest.this.setMouseMovedLabel3Flag(MouseMotionListenerTest.this.isMouseMovedLabel3Flag() | (modifiers2 & 0x1000) != 0);
            }
        });
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        Robot robot = harness.createRobot();
        robot.waitForIdle();
        robot.delay(1000);
        Rectangle bounds = label.getBounds();
        Point loc = frame.getLocationOnScreen();
        Insets i = frame.getInsets();
        bounds.x += i.left + loc.x;
        bounds.y += i.top + loc.y;
        int checkedPixelX = bounds.x + bounds.width / 2;
        int checkedPixelY = bounds.y + bounds.height / 2;
        Integer[] integerArray = new Integer[]{16, 8, 4};
        int n = integerArray.length;
        for (int j = 0; j < n; ++j) {
            int mouseLabel = integerArray[j];
            robot.mouseMove(0, 0);
            robot.waitForIdle();
            robot.mouseMove(checkedPixelX - 20, checkedPixelY);
            robot.waitForIdle();
            robot.delay(250);
            robot.mousePress(mouseLabel);
            robot.delay(250);
            robot.mouseMove(checkedPixelX + 20, checkedPixelY);
            robot.delay(250);
            robot.mouseRelease(mouseLabel);
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
        harness.check(this.isMouseDraggedLabel1Flag());
        harness.check(this.isMouseDraggedLabel2Flag());
        harness.check(this.isMouseDraggedLabel3Flag());
        harness.check(!this.isMouseMovedLabel1Flag());
        harness.check(!this.isMouseMovedLabel2Flag());
        harness.check(!this.isMouseMovedLabel3Flag());
    }

    @Override
    public void paint(Graphics graphics) {
        Image offScr = this.createImage(this.getSize().width, this.getSize().height);
        Graphics offG = offScr.getGraphics();
        offG.setClip(0, 0, this.getSize().width, this.getSize().height);
        super.paint(offG);
        graphics.drawImage(offScr, 0, 0, null);
        offG.dispose();
    }

    public void setMouseDraggedLabel1Flag(boolean mouseDraggedLabel1Flag) {
        this.mouseDraggedLabel1Flag = mouseDraggedLabel1Flag;
    }

    public boolean isMouseDraggedLabel1Flag() {
        return this.mouseDraggedLabel1Flag;
    }

    public void setMouseDraggedLabel2Flag(boolean mouseDraggedLabel2Flag) {
        this.mouseDraggedLabel2Flag = mouseDraggedLabel2Flag;
    }

    public boolean isMouseDraggedLabel2Flag() {
        return this.mouseDraggedLabel2Flag;
    }

    public void setMouseDraggedLabel3Flag(boolean mouseDraggedLabel3Flag) {
        this.mouseDraggedLabel3Flag = mouseDraggedLabel3Flag;
    }

    public boolean isMouseDraggedLabel3Flag() {
        return this.mouseDraggedLabel3Flag;
    }

    public void setMouseMovedLabel1Flag(boolean mouseMovedLabel1Flag) {
        this.mouseMovedLabel1Flag = mouseMovedLabel1Flag;
    }

    public boolean isMouseMovedLabel1Flag() {
        return this.mouseMovedLabel1Flag;
    }

    public void setMouseMovedLabel2Flag(boolean mouseMovedLabel2Flag) {
        this.mouseMovedLabel2Flag = mouseMovedLabel2Flag;
    }

    public boolean isMouseMovedLabel2Flag() {
        return this.mouseMovedLabel2Flag;
    }

    public void setMouseMovedLabel3Flag(boolean mouseMovedLabel3Flag) {
        this.mouseMovedLabel3Flag = mouseMovedLabel3Flag;
    }

    public boolean isMouseMovedLabel3Flag() {
        return this.mouseMovedLabel3Flag;
    }
}

