/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Graphics2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class clip
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testBufferedImageGraphics2D(harness);
    }

    public void testBufferedImageGraphics2D(TestHarness harness) {
        harness.checkPoint("BufferedImage Graphics2D");
        BufferedImage image = new BufferedImage(100, 80, 2);
        Graphics2D g2 = image.createGraphics();
        harness.check(g2.getClip(), null);
        g2.clip(new Rectangle(1, 2, 3, 4));
        harness.check(g2.getClip(), new Rectangle(1, 2, 3, 4));
        g2.clip(new Rectangle(0, 1, 3, 2));
        harness.check(g2.getClip(), new Rectangle(1, 2, 2, 1));
        g2.setClip(null);
        g2.translate(10, 20);
        g2.clip(new Rectangle(1, 2, 3, 4));
        harness.check(g2.getClip(), new Rectangle(1, 2, 3, 4));
        boolean pass = false;
        try {
            g2.clip(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

