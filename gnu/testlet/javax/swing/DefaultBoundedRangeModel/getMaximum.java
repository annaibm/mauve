/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultBoundedRangeModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultBoundedRangeModel;

public class getMaximum
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultBoundedRangeModel dbrm = new DefaultBoundedRangeModel();
        harness.check(dbrm.getMaximum(), 100);
        dbrm.setRangeProperties(3, 2, -4, 123, false);
        harness.check(dbrm.getMaximum(), 123);
    }
}

