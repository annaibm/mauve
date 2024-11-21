/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultBoundedRangeModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultBoundedRangeModel;

public class getValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultBoundedRangeModel dbrm = new DefaultBoundedRangeModel();
        harness.check(dbrm.getValue(), 0);
        dbrm.setRangeProperties(3, 2, -4, 10, false);
        harness.check(dbrm.getValue(), 3);
    }
}

