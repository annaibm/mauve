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

public class ScrollbarPaintTest
extends Panel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame frame = new Frame();
        List list2 = new List(2);
        list2.add("1");
        list2.add("2");
        list2.add("3");
        this.add(list2);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);
        Robot robot = harness.createRobot();
        robot.delay(1000);
        robot.waitForIdle();
        Rectangle bounds = list2.getBounds();
        Insets i = frame.getInsets();
        Point loc = frame.getLocationOnScreen();
        loc.x += i.left + bounds.x;
        loc.y += i.top + bounds.y;
        bounds.x += i.left;
        bounds.y += i.top;
        int checkedPixelX = loc.x + bounds.width - i.left - 2;
        int checkedPixelY = loc.y + bounds.height / 2;
        robot.mouseMove(checkedPixelX, checkedPixelY);
        robot.delay(1000);
        robot.waitForIdle();
        Color scroll = robot.getPixelColor(checkedPixelX, checkedPixelY);
        harness.check(!scroll.equals(Color.white));
        harness.check(!scroll.equals(Color.red));
        robot.waitForIdle();
        robot.delay(1000);
        frame.dispose();
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

