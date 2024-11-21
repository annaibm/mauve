/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.IndexColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.image.IndexColorModel;

public class getBlue
implements Testlet {
    private static final byte[] R4 = new byte[]{1, 2, 3, 4};
    private static final byte[] G4 = new byte[]{5, 6, 7, 8};
    private static final byte[] B4 = new byte[]{9, 10, 11, 12};

    @Override
    public void test(TestHarness harness) {
        IndexColorModel m1 = new IndexColorModel(2, 4, R4, G4, B4);
        harness.check(m1.getBlue(0), 9);
        harness.check(m1.getBlue(1), 10);
        harness.check(m1.getBlue(2), 11);
        harness.check(m1.getBlue(3), 12);
        boolean pass = false;
        try {
            m1.getGreen(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        harness.check(m1.getBlue(4), 0);
    }
}

