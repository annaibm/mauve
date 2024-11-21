/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Graphics2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class transform
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testBufferedImageGraphics2D(harness);
    }

    public void testBufferedImageGraphics2D(TestHarness harness) {
        harness.checkPoint("BufferedImage Graphics2D");
        BufferedImage image = new BufferedImage(100, 80, 2);
        Graphics2D g2 = image.createGraphics();
        harness.check(g2.getTransform().isIdentity());
        g2.setTransform(new AffineTransform(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        g2.transform(new AffineTransform(7.0, 8.0, 9.0, 10.0, 11.0, 12.0));
        AffineTransform current2 = g2.getTransform();
        harness.check(current2.getScaleX(), 31.0);
        harness.check(current2.getScaleY(), 58.0);
        harness.check(current2.getShearX(), 39.0);
        harness.check(current2.getShearY(), 46.0);
        harness.check(current2.getTranslateX(), 52.0);
        harness.check(current2.getTranslateY(), 76.0);
        g2.setTransform(new AffineTransform());
        g2.setClip(1, 2, 3, 4);
        Shape currentClip = g2.getClip();
        harness.check(currentClip, new Rectangle2D.Double(1.0, 2.0, 3.0, 4.0));
        g2.transform(AffineTransform.getTranslateInstance(10.0, 20.0));
        currentClip = g2.getClip();
        harness.check(currentClip, new Rectangle2D.Double(-9.0, -18.0, 3.0, 4.0));
    }
}

