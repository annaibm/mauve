/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.IndexColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.image.IndexColorModel;

public class getTransparentPixel
implements Testlet {
    private static final byte[] R4 = new byte[]{1, 2, 3, 4};
    private static final byte[] G4 = new byte[]{5, 6, 7, 8};
    private static final byte[] B4 = new byte[]{9, 10, 11, 12};
    private static final byte[] CMAP = new byte[]{1, 5, 9, 2, 6, 10, 3, 7, 11, 4, 8, 12};
    private static final byte[] CMAP_WITH_ALPHA = new byte[]{1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15, 4, 8, 12, 16};
    private static final int[] CMAP_INT = new int[]{new Color(1, 5, 9).getRGB(), new Color(2, 6, 10).getRGB(), new Color(3, 7, 11).getRGB(), new Color(4, 8, 12).getRGB()};

    @Override
    public void test(TestHarness harness) {
        IndexColorModel m1 = new IndexColorModel(2, 4, R4, G4, B4);
        harness.check(m1.getTransparentPixel(), -1);
        IndexColorModel m2a = new IndexColorModel(2, 4, R4, G4, B4, 2);
        harness.check(m2a.getTransparentPixel(), 2);
        IndexColorModel m2b = new IndexColorModel(2, 4, R4, G4, B4, -2);
        harness.check(m2b.getTransparentPixel(), -1);
        IndexColorModel m2c = new IndexColorModel(2, 4, R4, G4, B4, 99);
        harness.check(m2c.getTransparentPixel(), -1);
        IndexColorModel m3a = new IndexColorModel(2, 4, CMAP, 0, false, 2);
        harness.check(m3a.getTransparentPixel(), 2);
        IndexColorModel m3b = new IndexColorModel(2, 4, CMAP, 0, false, -2);
        harness.check(m3b.getTransparentPixel(), -1);
        IndexColorModel m3c = new IndexColorModel(2, 4, CMAP, 0, false, 99);
        harness.check(m3c.getTransparentPixel(), -1);
        IndexColorModel m4a = new IndexColorModel(2, 4, CMAP_WITH_ALPHA, 0, true, 2);
        harness.check(m4a.getTransparentPixel(), 2);
        IndexColorModel m4b = new IndexColorModel(2, 4, CMAP_WITH_ALPHA, 0, true, -2);
        harness.check(m4b.getTransparentPixel(), -1);
        IndexColorModel m4c = new IndexColorModel(2, 4, CMAP_WITH_ALPHA, 0, true, 99);
        harness.check(m4c.getTransparentPixel(), -1);
        IndexColorModel m5a = new IndexColorModel(2, 4, CMAP_INT, 0, false, 2, 0);
        harness.check(m5a.getTransparentPixel(), 2);
        IndexColorModel m5b = new IndexColorModel(2, 4, CMAP_INT, 0, false, -2, 0);
        harness.check(m5b.getTransparentPixel(), -1);
        IndexColorModel m5c = new IndexColorModel(2, 4, CMAP_INT, 0, false, 99, 0);
        harness.check(m5c.getTransparentPixel(), -1);
    }
}

