/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BorderLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;

public class PaintTestFiveCanvases
extends Panel
implements Testlet {
    private static final long serialVersionUID = -1422980716093055760L;
    public static int DELAY_AMOUNT = 250;

    @Override
    public void test(TestHarness harness) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.red);
        Frame frame = new Frame();
        Canvas canvas1 = new Canvas();
        Canvas canvas2 = new Canvas();
        Canvas canvas3 = new Canvas();
        Canvas canvas4 = new Canvas();
        Canvas canvas5 = new Canvas();
        canvas1.setSize(100, 100);
        canvas2.setSize(100, 100);
        canvas3.setSize(100, 100);
        canvas4.setSize(100, 100);
        canvas5.setSize(100, 100);
        canvas1.setBackground(Color.blue);
        canvas2.setBackground(Color.yellow);
        canvas3.setBackground(Color.magenta);
        canvas4.setBackground(Color.yellow);
        canvas5.setBackground(Color.blue);
        this.add((Component)canvas1, "North");
        this.add((Component)canvas2, "West");
        this.add((Component)canvas3, "Center");
        this.add((Component)canvas4, "East");
        this.add((Component)canvas5, "South");
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        Robot robot = harness.createRobot();
        robot.waitForIdle();
        robot.delay(DELAY_AMOUNT);
        harness.checkPoint("first component");
        harness.check(this.getColorForComponent(robot, frame, canvas1), Color.blue);
        harness.checkPoint("second component");
        harness.check(this.getColorForComponent(robot, frame, canvas2), Color.yellow);
        harness.checkPoint("third component");
        harness.check(this.getColorForComponent(robot, frame, canvas3), Color.magenta);
        harness.checkPoint("fourth component");
        harness.check(this.getColorForComponent(robot, frame, canvas4), Color.yellow);
        harness.checkPoint("fifth component");
        harness.check(this.getColorForComponent(robot, frame, canvas5), Color.blue);
        robot.waitForIdle();
        robot.delay(DELAY_AMOUNT);
        frame.dispose();
    }

    private Color getColorForComponent(Robot robot, Frame frame, Component component2) {
        Point p = this.computeCenterOfComponent(frame, component2);
        this.moveCursorToGivenPosition(robot, p.x, p.y);
        return robot.getPixelColor(p.x, p.y);
    }

    private Rectangle computeBounds(Frame frame, Component component2) {
        Rectangle bounds = component2.getBounds();
        Point location = frame.getLocationOnScreen();
        Insets insets = frame.getInsets();
        bounds.x += insets.left + location.x;
        bounds.y += insets.top + location.y;
        return bounds;
    }

    private Point computeCenterOfComponent(Frame frame, Component component2) {
        Rectangle bounds = this.computeBounds(frame, component2);
        int checkedPixelX = bounds.x + bounds.width / 2;
        int checkedPixelY = bounds.y + bounds.height / 2;
        return new Point(checkedPixelX, checkedPixelY);
    }

    private void moveCursorToGivenPosition(Robot robot, int checkedPixelX, int checkedPixelY) {
        robot.delay(DELAY_AMOUNT);
        robot.mouseMove(checkedPixelX, checkedPixelY);
        robot.delay(DELAY_AMOUNT);
        robot.waitForIdle();
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
}

