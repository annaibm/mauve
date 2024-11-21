/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.IndexColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.IndexColorModel;

public class getColorSpace
implements Testlet {
    private static final byte[] R4 = new byte[]{1, 2, 3, 4};
    private static final byte[] G4 = new byte[]{5, 6, 7, 8};
    private static final byte[] B4 = new byte[]{9, 10, 11, 12};
    private static final byte[] CMAP = new byte[]{1, 5, 9, 2, 6, 10, 3, 7, 11, 4, 8, 12};
    private static final byte[] CMAP_WITH_ALPHA = new byte[]{1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15, 4, 8, 12, 16};

    @Override
    public void test(TestHarness harness) {
        IndexColorModel m1 = new IndexColorModel(2, 4, R4, G4, B4);
        harness.check(m1.getColorSpace().isCS_sRGB());
        IndexColorModel m2 = new IndexColorModel(2, 4, R4, G4, B4, 2);
        harness.check(m2.getColorSpace().isCS_sRGB());
        IndexColorModel m3 = new IndexColorModel(2, 4, CMAP, 0, false);
        harness.check(m3.getColorSpace().isCS_sRGB());
        IndexColorModel m4 = new IndexColorModel(2, 4, CMAP_WITH_ALPHA, 0, true);
        harness.check(m4.getColorSpace().isCS_sRGB());
    }
}

