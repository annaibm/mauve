/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.IndexColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.IndexColorModel;

public class getComponentSize
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
        int[] cs1 = m1.getComponentSize();
        harness.check(cs1.length, 3);
        harness.check(cs1[0], 8);
        harness.check(cs1[1], 8);
        harness.check(cs1[2], 8);
        IndexColorModel m2 = new IndexColorModel(2, 4, R4, G4, B4, 2);
        int[] cs2 = m2.getComponentSize();
        harness.check(cs2.length, 4);
        harness.check(cs2[0], 8);
        harness.check(cs2[1], 8);
        harness.check(cs2[2], 8);
        harness.check(cs2[3], 8);
        IndexColorModel m3a = new IndexColorModel(2, 4, CMAP, 0, false);
        int[] cs3a = m3a.getComponentSize();
        harness.check(cs3a.length, 3);
        harness.check(cs3a[0], 8);
        harness.check(cs3a[1], 8);
        harness.check(cs3a[2], 8);
        IndexColorModel m3b = new IndexColorModel(2, 4, CMAP, 0, false, 1);
        int[] cs3b = m3b.getComponentSize();
        harness.check(cs3b.length, 4);
        harness.check(cs3b[0], 8);
        harness.check(cs3b[1], 8);
        harness.check(cs3b[2], 8);
        harness.check(cs3b[3], 8);
        IndexColorModel m4 = new IndexColorModel(2, 4, CMAP_WITH_ALPHA, 0, true);
        int[] cs4 = m4.getComponentSize();
        harness.check(cs4.length, 4);
        harness.check(cs4[0], 8);
        harness.check(cs4[1], 8);
        harness.check(cs4[2], 8);
        harness.check(cs4[3], 8);
        IndexColorModel m5 = new IndexColorModel(2, 4, CMAP_WITH_ALPHA0, 0, true);
        int[] cs5 = m5.getComponentSize();
        harness.check(cs5.length, 4);
        harness.check(cs5[0], 8);
        harness.check(cs5[1], 8);
        harness.check(cs5[2], 8);
        harness.check(cs5[3], 8);
        IndexColorModel m6 = new IndexColorModel(2, 4, CMAP_WITH_ALPHA1, 0, true);
        int[] cs6 = m6.getComponentSize();
        harness.check(cs6.length, 3);
        harness.check(cs6[0], 8);
        harness.check(cs6[1], 8);
        harness.check(cs6[2], 8);
    }
}

