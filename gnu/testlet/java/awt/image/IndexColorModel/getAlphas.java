/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.IndexColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.IndexColorModel;

public class getAlphas
implements Testlet {
    private static final byte[] R4 = new byte[]{1, 2, 3, 4};
    private static final byte[] G4 = new byte[]{5, 6, 7, 8};
    private static final byte[] B4 = new byte[]{9, 10, 11, 12};
    private static final byte[] A4 = new byte[]{13, 14, 15, 16};

    @Override
    public void test(TestHarness harness) {
        IndexColorModel m1 = new IndexColorModel(2, 4, R4, G4, B4, A4);
        byte[] a = new byte[4];
        m1.getAlphas(a);
        harness.check(a[0], 13);
        harness.check(a[1], 14);
        harness.check(a[2], 15);
        harness.check(a[3], 16);
        boolean pass = false;
        try {
            m1.getAlphas(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.getAlphas(new byte[3]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

