/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultBoundedRangeModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultBoundedRangeModel.setRangeProperties;
import javax.swing.DefaultBoundedRangeModel;

public class general
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultBoundedRangeModel dbrm = new DefaultBoundedRangeModel();
        setRangeProperties.check(harness, dbrm, 0, 0, 0, 100, false);
        dbrm = new DefaultBoundedRangeModel(5, 2, -1234, 4321);
        setRangeProperties.check(harness, dbrm, 5, 2, -1234, 4321, false);
        Exception caught = null;
        try {
            dbrm = new DefaultBoundedRangeModel(-2, 0, 10, 20);
        }
        catch (Exception ex) {
            caught = ex;
        }
        harness.check(caught instanceof IllegalArgumentException);
    }
}

