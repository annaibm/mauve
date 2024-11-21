/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.IndexColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.IndexColorModel;

public class getAlpha
implements Testlet {
    private static final byte[] R4 = new byte[]{1, 2, 3, 4};
    private static final byte[] G4 = new byte[]{5, 6, 7, 8};
    private static final byte[] B4 = new byte[]{9, 10, 11, 12};
    private static final byte[] A4 = new byte[]{13, 14, 15, 16};
    private static final byte[] CMAP = new byte[]{1, 5, 9, 2, 6, 10, 3, 7, 11, 4, 8, 12};

    @Override
    public void test(TestHarness harness) {
        IndexColorModel m1 = new IndexColorModel(2, 4, R4, G4, B4, A4);
        harness.check(m1.getAlpha(0), 13);
        harness.check(m1.getAlpha(1), 14);
        harness.check(m1.getAlpha(2), 15);
        harness.check(m1.getAlpha(3), 16);
        IndexColorModel m2 = new IndexColorModel(2, 4, CMAP, 0, false, 1);
        harness.check(m2.getAlpha(0), 255);
        harness.check(m2.getAlpha(1), 0);
        harness.check(m2.getAlpha(2), 255);
        harness.check(m2.getAlpha(3), 255);
        boolean pass = false;
        try {
            m1.getAlpha(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        harness.check(m1.getAlpha(99), 0);
    }
}

