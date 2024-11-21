/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JFrame;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.awt.LocationTests;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import javax.swing.JFrame;

public class HeavyweightComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int outer_width = 100;
        int outer_height = 100;
        int inner_width = 0;
        int inner_height = 0;
        Robot r = harness.createRobot();
        JFrame f = new JFrame();
        f.setLayout(null);
        Canvas c = new Canvas(){

            @Override
            public void paint(Graphics g) {
                Rectangle r = this.getBounds();
                g.setColor(Color.red);
                g.drawRect(r.x, r.y, r.width - 1, r.height - 1);
            }
        };
        f.setSize(outer_width, outer_height);
        f.add(c);
        f.show();
        r.waitForIdle();
        r.delay(1000);
        Insets i = f.getInsets();
        inner_width = outer_width - i.left - i.right;
        inner_height = outer_height - i.top - i.bottom;
        c.setBounds(0, 0, inner_width, inner_height);
        Point loc = f.getLocationOnScreen();
        Rectangle bounds = new Rectangle(loc.x + i.left, loc.y + i.top, inner_width, inner_height);
        r.waitForIdle();
        r.delay(1000);
        LocationTests.checkRectangleCornerColors(harness, r, bounds, Color.red, true);
        r.delay(3000);
    }
}

