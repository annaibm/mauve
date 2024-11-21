/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultBoundedRangeModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultBoundedRangeModel;

public class getExtent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultBoundedRangeModel dbrm = new DefaultBoundedRangeModel();
        harness.check(dbrm.getExtent(), 0);
        dbrm.setRangeProperties(3, 2, 0, 10, false);
        harness.check(dbrm.getExtent(), 2);
    }
}

