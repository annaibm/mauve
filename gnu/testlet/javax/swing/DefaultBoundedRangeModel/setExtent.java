/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultBoundedRangeModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultBoundedRangeModel.setRangeProperties;
import javax.swing.DefaultBoundedRangeModel;

public class setExtent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultBoundedRangeModel dbrm = new DefaultBoundedRangeModel();
        dbrm.setRangeProperties(8, 0, 0, 10, false);
        dbrm.setExtent(2);
        setRangeProperties.check(harness, dbrm, 8, 2, 0, 10, false);
        dbrm.setExtent(-1);
        setRangeProperties.check(harness, dbrm, 8, 0, 0, 10, false);
        dbrm.setRangeProperties(7, 2, 0, 10, false);
        dbrm.setExtent(4);
        setRangeProperties.check(harness, dbrm, 7, 3, 0, 10, false);
        dbrm.setRangeProperties(7, 2, 0, 10, false);
        dbrm.setExtent(20);
        setRangeProperties.check(harness, dbrm, 7, 3, 0, 10, false);
    }
}

