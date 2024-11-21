/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Window;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Robot;

public class pack1
implements Testlet {
    Color bg = new Color(243, 133, 89);
    Color border = new Color(255, 0, 0);

    public void checkColor(TestHarness harness, Color c) {
        harness.check(c.getRed() == this.border.getRed() && c.getGreen() == this.border.getGreen() && c.getBlue() == this.border.getBlue());
    }

    @Override
    public void test(TestHarness harness) {
        Robot r = harness.createRobot();
        int x = 100;
        int y = 100;
        int width = 100;
        int height = 100;
        pack1Frame f = new pack1Frame();
        f.setLocation(x, y);
        f.setSize(width, height);
        f.add(new pack1Canvas());
        r.setAutoDelay(100);
        r.setAutoWaitForIdle(true);
        f.show();
        r.waitForIdle();
        r.delay(100);
        Insets i = f.getInsets();
        int top_y = y + i.top;
        int bottom_y = y + height - i.bottom - 1;
        int left_x = x + i.left;
        int right_x = x + width - i.right - 1;
        Color c = r.getPixelColor(left_x, top_y + 1);
        this.checkColor(harness, c);
        c = r.getPixelColor(left_x + 1, top_y);
        this.checkColor(harness, c);
        c = r.getPixelColor(right_x, top_y + 1);
        this.checkColor(harness, c);
        c = r.getPixelColor(right_x - 1, top_y);
        this.checkColor(harness, c);
        c = r.getPixelColor(left_x, bottom_y - 1);
        this.checkColor(harness, c);
        c = r.getPixelColor(left_x + 1, bottom_y);
        this.checkColor(harness, c);
        c = r.getPixelColor(right_x, bottom_y - 1);
        this.checkColor(harness, c);
        c = r.getPixelColor(right_x - 1, bottom_y);
        this.checkColor(harness, c);
        r.delay(4000);
    }

    class pack1Canvas
    extends Canvas {
        public pack1Canvas() {
            this.setBackground(pack1.this.bg);
        }

        @Override
        public void paint(Graphics g) {
            Rectangle bounds = new Rectangle(0, 0, this.getSize().width, this.getSize().height);
            g.setColor(pack1.this.border);
            g.drawRect(bounds.x, bounds.y, bounds.width - 1, bounds.height - 1);
        }
    }

    class pack1Frame
    extends Frame {
    }
}

