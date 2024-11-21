/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Graphics;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class clearRect
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        BufferedImage img = new BufferedImage(20, 20, 2);
        Graphics2D g2d = (Graphics2D)img.getGraphics();
        harness.check(g2d.getBackground(), new Color(0, 0, 0, 255));
        harness.check(img.getRaster().getSample(10, 10, 0), 0);
        harness.check(img.getRaster().getSample(10, 10, 1), 0);
        harness.check(img.getRaster().getSample(10, 10, 2), 0);
        harness.check(img.getRaster().getSample(10, 10, 3), 0);
        g2d.setColor(new Color(200, 200, 200, 50));
        g2d.setComposite(AlphaComposite.getInstance(3, 0.5f));
        g2d.setPaint(new GradientPaint(new Point2D.Double(0.0, 0.0), new Color(10, 10, 10), new Point2D.Double(20.0, 20.0), new Color(75, 75, 75), true));
        Color c = new Color(100, 100, 100);
        g2d.setBackground(c);
        g2d.clearRect(0, 0, 20, 20);
        harness.check(img.isAlphaPremultiplied(), false);
        harness.check(g2d.getBackground(), c);
        harness.check(img.getRaster().getSample(10, 10, 0), 100);
        harness.check(img.getRaster().getSample(10, 10, 1), 100);
        harness.check(img.getRaster().getSample(10, 10, 2), 100);
        harness.check(img.getRaster().getSample(10, 10, 3), 255);
        c = new Color(200, 200, 200, 51);
        g2d.setBackground(c);
        g2d.clearRect(0, 0, 20, 20);
        harness.check(img.isAlphaPremultiplied(), false);
        harness.check(g2d.getBackground(), c);
        harness.check(img.getRaster().getSample(10, 10, 0), 200);
        harness.check(img.getRaster().getSample(10, 10, 1), 200);
        harness.check(img.getRaster().getSample(10, 10, 2), 200);
        harness.check(img.getRaster().getSample(10, 10, 3), 51);
    }
}

