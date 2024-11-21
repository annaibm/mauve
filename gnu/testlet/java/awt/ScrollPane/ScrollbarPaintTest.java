/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.ScrollPane;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.ScrollPane;

public class ScrollbarPaintTest
extends Panel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame f = new Frame();
        ScrollPane c = new ScrollPane(1);
        this.add(c);
        f.add(this);
        f.pack();
        f.show();
        Robot r = harness.createRobot();
        r.waitForIdle();
        r.delay(1000);
        Rectangle bounds = c.getBounds();
        Point loc = f.getLocationOnScreen();
        Insets i = f.getInsets();
        loc.x += i.left + bounds.x;
        loc.y += i.top + bounds.y;
        bounds.width -= i.left + i.right;
        bounds.height -= i.top + i.bottom;
        Color scroll = r.getPixelColor(loc.x + bounds.width, loc.y + bounds.height / 2);
        harness.check(!scroll.equals(Color.red));
        r.waitForIdle();
        r.delay(2000);
        f.dispose();
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

