/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultBoundedRangeModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultBoundedRangeModel.setRangeProperties;
import javax.swing.DefaultBoundedRangeModel;

public class setValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultBoundedRangeModel dbrm = new DefaultBoundedRangeModel();
        dbrm.setRangeProperties(1, 1, 0, 10, false);
        dbrm.setValue(5);
        setRangeProperties.check(harness, dbrm, 5, 1, 0, 10, false);
        dbrm.setRangeProperties(4, 1, 3, 10, false);
        dbrm.setValue(-5);
        setRangeProperties.check(harness, dbrm, 3, 1, 3, 10, false);
        dbrm.setRangeProperties(4, 0, 3, 10, false);
        dbrm.setValue(140);
        setRangeProperties.check(harness, dbrm, 10, 0, 3, 10, false);
        dbrm.setRangeProperties(4, 4, 3, 10, false);
        dbrm.setValue(9);
        setRangeProperties.check(harness, dbrm, 6, 4, 3, 10, false);
    }
}

