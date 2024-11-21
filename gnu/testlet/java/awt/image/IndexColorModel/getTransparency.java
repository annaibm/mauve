/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.IndexColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.IndexColorModel;

public class getTransparency
implements Testlet {
    private static final byte[] R4 = new byte[]{1, 2, 3, 4};
    private static final byte[] G4 = new byte[]{5, 6, 7, 8};
    private static final byte[] B4 = new byte[]{9, 10, 11, 12};
    private static final byte[] CMAP = new byte[]{1, 5, 9, 2, 6, 10, 3, 7, 11, 4, 8, 12};
    private static final byte[] CMAP_WITH_ALPHA = new byte[]{1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15, 4, 8, 12, 16};
    private static final byte[] CMAP_WITH_ALPHA0 = new byte[]{1, 5, 9, 0, 2, 6, 10, 0, 3, 7, 11, 0, 4, 8, 12, 0};
    private static final byte[] CMAP_WITH_ALPHA1 = new byte[]{1, 5, 9, -1, 2, 6, 10, -1, 3, 7, 11, -1, 4, 8, 12, -1};

    @Override
    public void test(TestHarness harness) {
        IndexColorModel m1 = new IndexColorModel(2, 4, R4, G4, B4);
        harness.check(m1.getTransparency(), 1);
        IndexColorModel m2a = new IndexColorModel(2, 4, R4, G4, B4, 2);
        harness.check(m2a.getTransparency(), 2);
        IndexColorModel m2b = new IndexColorModel(2, 4, R4, G4, B4, -1);
        harness.check(m2b.getTransparency(), 1);
        IndexColorModel m2c = new IndexColorModel(2, 4, R4, G4, B4, 99);
        harness.check(m2c.getTransparency(), 1);
        IndexColorModel m3a = new IndexColorModel(2, 4, CMAP, 0, false);
        harness.check(m3a.getTransparency(), 1);
        IndexColorModel m3b = new IndexColorModel(2, 4, CMAP, 0, false, 2);
        harness.check(m3b.getTransparency(), 2);
        IndexColorModel m4a = new IndexColorModel(2, 4, CMAP_WITH_ALPHA, 0, true);
        harness.check(m4a.getTransparency(), 3);
        IndexColorModel m4b = new IndexColorModel(2, 4, CMAP_WITH_ALPHA, 0, true, 2);
        harness.check(m4b.getTransparency(), 3);
        IndexColorModel m5a = new IndexColorModel(2, 4, CMAP_WITH_ALPHA0, 0, true);
        harness.check(m5a.getTransparency(), 2);
        IndexColorModel m5b = new IndexColorModel(2, 4, CMAP_WITH_ALPHA0, 0, true, 2);
        harness.check(m5b.getTransparency(), 2);
        IndexColorModel m6a = new IndexColorModel(2, 4, CMAP_WITH_ALPHA1, 0, true);
        harness.check(m6a.getTransparency(), 1);
        IndexColorModel m6b = new IndexColorModel(2, 4, CMAP_WITH_ALPHA1, 0, true, 2);
        harness.check(m6b.getTransparency(), 2);
    }
}

