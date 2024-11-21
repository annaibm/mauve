/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.GridLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;

public class PaintTestZeroHgap
extends Panel
implements Testlet {
    private static final long serialVersionUID = 42L;
    public static int DELAY_AMOUNT = 250;

    @Override
    public void test(TestHarness harness) {
        GridLayout layout2 = new GridLayout(2, 3);
        layout2.setHgap(0);
        this.setLayout(layout2);
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
        this.add(canvas1);
        this.add(canvas2);
        this.add(canvas3);
        this.add(canvas4);
        this.add(canvas5);
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
        harness.checkPoint("background");
        harness.check(this.getBackgroundColor(robot, frame, canvas3, canvas5), Color.red);
        harness.checkPoint("space check #1");
        harness.check(this.getColorBetweenComponents(robot, frame, canvas1, canvas2) != Color.red);
        harness.checkPoint("space check #2");
        harness.check(this.getColorBetweenComponents(robot, frame, canvas2, canvas3) != Color.red);
        harness.checkPoint("space check #3");
        harness.check(this.getColorBetweenComponents(robot, frame, canvas4, canvas5) != Color.red);
        harness.checkPoint("space check #4");
        harness.check(this.getColorBetweenComponents(robot, frame, canvas1, canvas4) != Color.red);
        harness.checkPoint("space check #5");
        harness.check(this.getColorBetweenComponents(robot, frame, canvas2, canvas5) != Color.red);
        harness.checkPoint("space check #6");
        harness.check(this.getColorBetweenComponents(robot, frame, canvas1, canvas5) != Color.red);
        robot.waitForIdle();
        robot.delay(DELAY_AMOUNT);
        frame.dispose();
    }

    private Color getColorForComponent(Robot robot, Frame frame, Component component2) {
        Rectangle bounds = this.computeBounds(frame, component2);
        int checkedPixelX = bounds.x + bounds.width / 2;
        int checkedPixelY = bounds.y + bounds.height / 2;
        this.moveCursorToGivenPosition(robot, checkedPixelX, checkedPixelY);
        return robot.getPixelColor(checkedPixelX, checkedPixelY);
    }

    private Color getBackgroundColor(Robot robot, Frame frame, Component component1, Component component2) {
        Rectangle bounds1 = this.computeBounds(frame, component1);
        Rectangle bounds2 = this.computeBounds(frame, component2);
        int checkedPixelX = bounds1.x + bounds1.width / 2;
        int checkedPixelY = bounds2.y + bounds2.height / 2;
        this.moveCursorToGivenPosition(robot, checkedPixelX, checkedPixelY);
        return robot.getPixelColor(checkedPixelX, checkedPixelY);
    }

    private Color getColorBetweenComponents(Robot robot, Frame frame, Component component1, Component component2) {
        Point p1 = this.computeCenterOfComponent(frame, component1);
        Point p2 = this.computeCenterOfComponent(frame, component2);
        int checkedPixelX = p1.x + p2.x >> 1;
        int checkedPixelY = p1.y + p2.y >> 1;
        this.moveCursorToGivenPosition(robot, checkedPixelX, checkedPixelY);
        return robot.getPixelColor(checkedPixelX, checkedPixelY);
    }

    private Point computeCenterOfComponent(Frame frame, Component component2) {
        Rectangle bounds = this.computeBounds(frame, component2);
        int checkedPixelX = bounds.x + bounds.width / 2;
        int checkedPixelY = bounds.y + bounds.height / 2;
        return new Point(checkedPixelX, checkedPixelY);
    }

    private Rectangle computeBounds(Frame frame, Component component2) {
        Rectangle bounds = component2.getBounds();
        Point location = frame.getLocationOnScreen();
        Insets insets = frame.getInsets();
        bounds.x += insets.left + location.x;
        bounds.y += insets.top + location.y;
        return bounds;
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

