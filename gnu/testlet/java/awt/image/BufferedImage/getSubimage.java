/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.BufferedImage;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;

public class getSubimage
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        int b;
        int y;
        int x;
        BufferedImage img = new BufferedImage(50, 50, 1);
        for (int x2 = 0; x2 < 50; ++x2) {
            for (int y2 = 0; y2 < 50; ++y2) {
                for (int b2 = 0; b2 < 3; ++b2) {
                    img.getRaster().setSample(x2, y2, b2, x2 + y2 + b2);
                }
            }
        }
        BufferedImage img2 = img.getSubimage(0, 0, 50, 50);
        harness.check(img.getRaster() != img2.getRaster());
        harness.check(img.getRaster().getDataBuffer(), img2.getRaster().getDataBuffer());
        harness.check(img.getSampleModel(), img2.getSampleModel());
        harness.check(img.getColorModel(), img2.getColorModel());
        harness.check(img2.getMinX(), 0);
        harness.check(img2.getMinY(), 0);
        harness.check(img2.getWidth(), 50);
        harness.check(img2.getHeight(), 50);
        for (x = 0; x < 50; ++x) {
            for (y = 0; y < 50; ++y) {
                for (b = 0; b < 3; ++b) {
                    harness.check(img2.getRaster().getSample(x, y, b), x + y + b);
                }
            }
        }
        img2 = img.getSubimage(20, 30, 15, 10);
        harness.check(img.getRaster().getDataBuffer(), img2.getRaster().getDataBuffer());
        harness.check(img.getSampleModel(), img2.getSampleModel());
        harness.check(img2.getMinX(), 0);
        harness.check(img2.getMinY(), 0);
        harness.check(img2.getWidth(), 15);
        harness.check(img2.getHeight(), 10);
        for (x = 0; x < 15; ++x) {
            for (y = 0; y < 10; ++y) {
                for (b = 0; b < 3; ++b) {
                    harness.check(img2.getRaster().getSample(x, y, b), x + 20 + y + 30 + b);
                }
            }
        }
        try {
            img2 = img.getSubimage(40, 40, 20, 20);
            harness.check(false);
        }
        catch (RasterFormatException ex) {
            harness.check(true);
        }
    }
}

