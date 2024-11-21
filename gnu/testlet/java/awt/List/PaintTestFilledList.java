/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.List;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.List;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;

public class PaintTestFilledList
extends Panel
implements Testlet {
    private static final long serialVersionUID = -6498456149126246476L;

    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame frame = new Frame();
        List list2 = new List(10);
        list2.setBackground(Color.blue);
        for (int i = 0; i < 10; ++i) {
            list2.add("item # " + i);
        }
        this.add(list2);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        Robot robot = harness.createRobot();
        robot.waitForIdle();
        robot.delay(1000);
        Point loc = frame.getLocationOnScreen();
        Rectangle bounds = list2.getBounds();
        Insets i = frame.getInsets();
        bounds.x += loc.x + i.left;
        bounds.y += loc.y + i.top;
        int checkedPixelX = bounds.x + bounds.width * 2 / 3;
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

