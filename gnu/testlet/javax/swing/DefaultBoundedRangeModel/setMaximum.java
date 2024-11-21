/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultBoundedRangeModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultBoundedRangeModel.setRangeProperties;
import javax.swing.DefaultBoundedRangeModel;

public class setMaximum
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultBoundedRangeModel dbrm = new DefaultBoundedRangeModel();
        dbrm.setRangeProperties(1, 1, 0, 10, false);
        dbrm.setMaximum(20);
        setRangeProperties.check(harness, dbrm, 1, 1, 0, 20, false);
        dbrm.setRangeProperties(600, 10, -3, 700, true);
        dbrm.setMaximum(543);
        setRangeProperties.check(harness, dbrm, 533, 10, -3, 543, true);
        dbrm.setRangeProperties(600, 10, -3, 700, true);
        dbrm.setMaximum(-4);
        setRangeProperties.check(harness, dbrm, -4, 0, -4, -4, true);
    }
}

