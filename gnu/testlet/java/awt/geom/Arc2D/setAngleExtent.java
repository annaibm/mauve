/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;

public class setAngleExtent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc = new Arc2D.Double(0.0, 0.0, 1.0, 1.0, 0.0, 90.0, 2);
        ((Arc2D)arc).setAngleExtent(85.0);
        harness.check(((Arc2D)arc).getAngleExtent(), 85.0);
    }
}

