/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.CardLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;
import java.awt.CardLayout;
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

public class PaintTestBiggerVGap
extends Panel
implements Testlet {
    public static int DELAY_AMOUNT = 250;
    public static int HGAP_SIZE = 0;
    public static int VGAP_SIZE = 50;
    public static int OFFSET_FROM_BORDER = VGAP_SIZE / 2;
    public static Color BACKGROUND_COLOR = Color.red;

    @Override
    public void test(TestHarness harness) {
        CardLayout layout2 = new CardLayout(HGAP_SIZE, VGAP_SIZE);
        this.setLayout(layout2);
        this.setBackground(BACKGROUND_COLOR);
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
        canvas5.setBackground(Color.cyan);
        this.add(canvas1);
        this.add(canvas2);
        this.add(canvas3);
        this.add(canvas4);
        this.add(canvas5);
        frame.add(this);
        frame.pack();
        frame.show();
        Robot robot = harness.createRobot();
        robot.waitForIdle();
        robot.delay(DELAY_AMOUNT);
        harness.checkPoint("first component");
        layout2.first(this);
        this.doTest(harness, robot, frame, canvas1, Color.blue);
        harness.checkPoint("second component");
        layout2.next(this);
        this.doTest(harness, robot, frame, canvas2, Color.yellow);
        harness.checkPoint("third component");
        layout2.next(this);
        this.doTest(harness, robot, frame, canvas3, Color.magenta);
        harness.checkPoint("fourth component");
        layout2.next(this);
        this.doTest(harness, robot, frame, canvas4, Color.yellow);
        harness.checkPoint("fifth component");
        layout2.next(this);
        this.doTest(harness, robot, frame, canvas5, Color.cyan);
        robot.waitForIdle();
        robot.delay(DELAY_AMOUNT);
        frame.dispose();
    }

    private void doTest(TestHarness harness, Robot robot, Frame frame, Component component2, Color componentColor) {
        robot.waitForIdle();
        robot.delay(DELAY_AMOUNT);
        harness.check(this.getColorForComponent(robot, frame, component2), componentColor);
        harness.check(this.getColorForLeftBorder(robot, frame, component2), componentColor);
        harness.check(this.getColorForRightBorder(robot, frame, component2), componentColor);
        harness.check(this.getColorForTopBorder(robot, frame, component2), BACKGROUND_COLOR);
        harness.check(this.getColorForBottomBorder(robot, frame, component2), BACKGROUND_COLOR);
    }

    private Color getColorForComponent(Robot robot, Frame frame, Component component2) {
        Point p = this.computeCenterOfComponent(frame, component2);
        this.moveCursorToGivenPosition(robot, p.x, p.y);
        return robot.getPixelColor(p.x, p.y);
    }

    private Color getColorForLeftBorder(Robot robot, Frame frame, Component component2) {
        Point p = this.computeCenterOfComponent(frame, component2);
        p.x = OFFSET_FROM_BORDER;
        this.moveCursorToGivenPosition(robot, p.x, p.y);
        return robot.getPixelColor(p.x, p.y);
    }

    private Color getColorForRightBorder(Robot robot, Frame frame, Component component2) {
        Point p = this.computeCenterOfComponent(frame, component2);
        p.x = frame.getWidth() - OFFSET_FROM_BORDER;
        this.moveCursorToGivenPosition(robot, p.x, p.y);
        return robot.getPixelColor(p.x, p.y);
    }

    private Color getColorForTopBorder(Robot robot, Frame frame, Component component2) {
        Point p = this.computeCenterOfComponent(frame, component2);
        p.y = p.y - component2.getHeight() / 2 - OFFSET_FROM_BORDER;
        this.moveCursorToGivenPosition(robot, p.x, p.y);
        return robot.getPixelColor(p.x, p.y);
    }

    private Color getColorForBottomBorder(Robot robot, Frame frame, Component component2) {
        Point p = this.computeCenterOfComponent(frame, component2);
        p.y = p.y + component2.getHeight() / 2 + OFFSET_FROM_BORDER;
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
    public void paint(Graphics g) {
        Image offScr = this.createImage(this.getSize().width, this.getSize().height);
        Graphics offG = offScr.getGraphics();
        offG.setClip(0, 0, this.getSize().width, this.getSize().height);
        super.paint(offG);
        g.drawImage(offScr, 0, 0, null);
        offG.dispose();
    }
}

