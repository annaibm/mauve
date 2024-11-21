/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BorderLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;
import java.awt.Button;
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

public class PaintTestFiveButtons
extends Panel
implements Testlet {
    private static final long serialVersionUID = -4358380772628343583L;
    public static int DELAY_AMOUNT = 250;

    @Override
    public void test(TestHarness harness) {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.red);
        Frame frame = new Frame();
        Button button1 = new Button("             ");
        Button button2 = new Button("             ");
        Button button3 = new Button("             ");
        Button button4 = new Button("             ");
        Button button5 = new Button("             ");
        button1.setBackground(Color.blue);
        button2.setBackground(Color.yellow);
        button3.setBackground(Color.magenta);
        button4.setBackground(Color.yellow);
        button5.setBackground(Color.blue);
        this.add((Component)button1, "North");
        this.add((Component)button2, "West");
        this.add((Component)button3, "Center");
        this.add((Component)button4, "East");
        this.add((Component)button5, "South");
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        Robot robot = harness.createRobot();
        robot.waitForIdle();
        robot.delay(DELAY_AMOUNT);
        harness.checkPoint("first component");
        harness.check(this.getColorForComponent(robot, frame, button1), Color.blue);
        harness.checkPoint("second component");
        harness.check(this.getColorForComponent(robot, frame, button2), Color.yellow);
        harness.checkPoint("third component");
        harness.check(this.getColorForComponent(robot, frame, button3), Color.magenta);
        harness.checkPoint("fourth component");
        harness.check(this.getColorForComponent(robot, frame, button4), Color.yellow);
        harness.checkPoint("fifth component");
        harness.check(this.getColorForComponent(robot, frame, button5), Color.blue);
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

