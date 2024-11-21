/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;

public class getDeterminant
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t = new AffineTransform(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
        harness.check(t.getDeterminant(), -2.0);
    }
}

