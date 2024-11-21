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
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseWheelListenerTest
extends Panel
implements Testlet {
    private static final long serialVersionUID = -4774724125231540431L;
    private boolean mouseWheelScrollUpFlag = false;
    private boolean mouseWheelScrollDownFlag = false;

    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame frame = new Frame();
        Label label = new Label("xyzzy");
        label.setBackground(Color.blue);
        this.add(label);
        label.addMouseWheelListener(new MouseWheelListener(){

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                MouseWheelListenerTest.this.setMouseWheelScrollUpFlag(MouseWheelListenerTest.this.isMouseWheelScrollUpFlag() | e.getWheelRotation() < 0);
                MouseWheelListenerTest.this.setMouseWheelScrollDownFlag(MouseWheelListenerTest.this.isMouseWheelScrollDownFlag() | e.getWheelRotation() > 0);
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
        robot.mouseMove(checkedPixelX, checkedPixelY);
        robot.waitForIdle();
        robot.delay(250);
        robot.mouseWheel(1);
        robot.delay(250);
        robot.mouseWheel(-1);
        robot.delay(250);
        robot.waitForIdle();
        robot.delay(1000);
        frame.dispose();
        harness.check(this.isMouseWheelScrollUpFlag());
        harness.check(this.isMouseWheelScrollDownFlag());
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

    public void setMouseWheelScrollUpFlag(boolean mouseWheelScrollUpFlag) {
        this.mouseWheelScrollUpFlag = mouseWheelScrollUpFlag;
    }

    public boolean isMouseWheelScrollUpFlag() {
        return this.mouseWheelScrollUpFlag;
    }

    public void setMouseWheelScrollDownFlag(boolean mouseWheelScrollDownFlag) {
        this.mouseWheelScrollDownFlag = mouseWheelScrollDownFlag;
    }

    public boolean isMouseWheelScrollDownFlag() {
        return this.mouseWheelScrollDownFlag;
    }
}

