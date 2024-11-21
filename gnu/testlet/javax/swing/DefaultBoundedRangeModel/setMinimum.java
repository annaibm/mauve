/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultBoundedRangeModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultBoundedRangeModel.setRangeProperties;
import javax.swing.DefaultBoundedRangeModel;

public class setMinimum
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultBoundedRangeModel dbrm = new DefaultBoundedRangeModel();
        dbrm.setRangeProperties(7, 2, 0, 10, true);
        dbrm.setMinimum(3);
        setRangeProperties.check(harness, dbrm, 7, 2, 3, 10, true);
        dbrm.setRangeProperties(7, 2, 0, 10, false);
        dbrm.setMinimum(8);
        setRangeProperties.check(harness, dbrm, 8, 2, 8, 10, false);
        dbrm.setRangeProperties(7, 2, 0, 10, false);
        dbrm.setMinimum(9);
        setRangeProperties.check(harness, dbrm, 9, 1, 9, 10, false);
        dbrm.setRangeProperties(7, 2, 0, 10, false);
        dbrm.setMinimum(200);
        setRangeProperties.check(harness, dbrm, 200, 0, 200, 200, false);
        dbrm.setRangeProperties(7, 2, 0, 10, false);
        dbrm.setMinimum(-20);
        setRangeProperties.check(harness, dbrm, 7, 2, -20, 10, false);
    }
}

