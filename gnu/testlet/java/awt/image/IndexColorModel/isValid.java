/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.image.IndexColorModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import java.awt.image.IndexColorModel;
import java.math.BigInteger;

public class isValid
implements Testlet {
    private static final byte[] R4 = new byte[]{1, 2, 3, 4};
    private static final byte[] G4 = new byte[]{5, 6, 7, 8};
    private static final byte[] B4 = new byte[]{9, 10, 11, 12};
    private static final int[] CMAP_INT = new int[]{new Color(1, 5, 9).getRGB(), new Color(2, 6, 10).getRGB(), new Color(3, 7, 11).getRGB(), new Color(4, 8, 12).getRGB()};

    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("isValid()");
        IndexColorModel m1 = new IndexColorModel(2, 4, R4, G4, B4);
        harness.check(m1.isValid());
        IndexColorModel m2 = new IndexColorModel(2, 4, CMAP_INT, 0, 0, new BigInteger("11"));
        harness.check(!m2.isValid());
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("isValid(int)");
        IndexColorModel m1 = new IndexColorModel(2, 4, R4, G4, B4);
        harness.check(m1.isValid(0));
        try {
            harness.check(!m1.isValid(-1));
        }
        catch (Exception e) {
            harness.debug(e);
        }
        harness.check(!m1.isValid(4));
        IndexColorModel m2 = new IndexColorModel(2, 4, CMAP_INT, 0, 0, new BigInteger("11"));
        harness.check(m2.isValid(0));
        harness.check(m2.isValid(1));
        harness.check(!m2.isValid(2));
        harness.check(m2.isValid(3));
    }
}

