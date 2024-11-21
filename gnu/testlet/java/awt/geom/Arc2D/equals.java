/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.geom.Arc2D;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.geom.Arc2D;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Arc2D.Double arc1 = new Arc2D.Double();
        Arc2D.Double arc2 = new Arc2D.Double();
        harness.check(!arc1.equals(arc2));
        harness.check(!arc1.equals(null));
    }
}

