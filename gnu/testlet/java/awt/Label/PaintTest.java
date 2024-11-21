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

public class PaintTest
extends Panel
implements Testlet {
    private static final long serialVersionUID = 4737615313184489246L;

    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame frame = new Frame();
        Label label = new Label("label");
        label.setBackground(Color.blue);
        this.add(label);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        Robot robot = harness.createRobot();
        robot.waitForIdle();
        robot.delay(1000);
        Point loc = frame.getLocationOnScreen();
        Rectangle bounds = label.getBounds();
        Insets i = frame.getInsets();
        bounds.x += loc.x + i.left;
        bounds.y += loc.y + i.top;
        int checkedPixelX = bounds.x + bounds.width / 2;
        int checkedPixelY = bounds.y + bounds.height / 2 + 5;
        robot.mouseMove(checkedPixelX, checkedPixelY);
        robot.waitForIdle();
        Color labelColor = robot.getPixelColor(checkedPixelX, checkedPixelY);
        harness.check(labelColor.equals(Color.blue));
        robot.waitForIdle();
        robot.delay(1000);
        frame.dispose();
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

