/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Button;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;

public class PaintTest
extends Panel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.setBackground(Color.red);
        Frame f = new Frame();
        Button b = new Button("             ");
        b.setBackground(Color.blue);
        this.add(b);
        f.add(this);
        f.pack();
        f.show();
        Robot r = harness.createRobot();
        r.waitForIdle();
        r.delay(1000);
        Rectangle bounds = b.getBounds();
        Point loc = f.getLocationOnScreen();
        Insets i = f.getInsets();
        bounds.x += i.left + loc.x;
        bounds.y += i.top + loc.y;
        int checkedPixelX = bounds.x + bounds.width / 2;
        int checkedPixelY = bounds.y + bounds.height / 2;
        r.mouseMove(checkedPixelX, checkedPixelY);
        r.waitForIdle();
        Color but = r.getPixelColor(checkedPixelX, checkedPixelY);
        harness.check(but.equals(Color.blue));
        r.waitForIdle();
        r.delay(1000);
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

