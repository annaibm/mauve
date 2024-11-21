/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;

public class getMatrix
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t = new AffineTransform(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        double[] m = new double[4];
        t.getMatrix(m);
        harness.check(m[0], 1.0);
        harness.check(m[1], 2.0);
        harness.check(m[2], 3.0);
        harness.check(m[3], 4.0);
        m = new double[6];
        t.getMatrix(m);
        harness.check(m[0], 1.0);
        harness.check(m[1], 2.0);
        harness.check(m[2], 3.0);
        harness.check(m[3], 4.0);
        harness.check(m[4], 5.0);
        harness.check(m[5], 6.0);
        boolean pass = false;
        m = new double[2];
        try {
            t.getMatrix(m);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            t.getMatrix(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

