/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Graphics2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class getClipBounds
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testBufferedImageGraphics2D(harness);
    }

    public void testBufferedImageGraphics2D(TestHarness harness) {
        harness.checkPoint("BufferedImage Graphics2D");
        BufferedImage image = new BufferedImage(100, 80, 2);
        Graphics2D g2 = image.createGraphics();
        harness.check(g2.getClipBounds(), null);
        g2.setClip(1, 2, 3, 4);
        harness.check(g2.getClipBounds(), new Rectangle(1, 2, 3, 4));
        g2.setClip(null);
        harness.check(g2.getClipBounds(), null);
    }
}

