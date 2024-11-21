/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.FlowLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;

public class PaintTestLeftAlign
extends Panel
implements Testlet {
    public static int DELAY_AMOUNT = 250;

    @Override
    public void test(TestHarness harness) {
        this.setLayout(new FlowLayout(0));
        this.setBackground(Color.red);
        Frame frame = new Frame();
        frame.setSize(300, 300);
        Button button = new Button("             ");
        Canvas canvas = new Canvas();
        canvas.setSize(100, 100);
        button.setBackground(Color.blue);
        canvas.setBackground(Color.yellow);
        this.add(button);
        this.add(canvas);
        frame.add(this);
        frame.show();
        Robot robot = harness.createRobot();
        robot.waitForIdle();
        robot.delay(DELAY_AMOUNT);
        harness.checkPoint("first component");
        harness.check(this.getColorForComponent(robot, frame, button), Color.blue);
        harness.checkPoint("second component");
        harness.check(this.getColorForComponent(robot, frame, canvas), Color.yellow);
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
    public void paint(Graphics g) {
        Image offScr = this.createImage(this.getSize().width, this.getSize().height);
        Graphics offG = offScr.getGraphics();
        offG.setClip(0, 0, this.getSize().width, this.getSize().height);
        super.paint(offG);
        g.drawImage(offScr, 0, 0, null);
        offG.dispose();
    }
}

