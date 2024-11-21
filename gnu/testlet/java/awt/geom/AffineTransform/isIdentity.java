/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.AffineTransform;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.AffineTransform;

public class isIdentity
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AffineTransform t0 = new AffineTransform();
        harness.check(t0.isIdentity());
        AffineTransform t1 = AffineTransform.getScaleInstance(0.5, 0.25);
        harness.check(!t1.isIdentity());
    }
}

