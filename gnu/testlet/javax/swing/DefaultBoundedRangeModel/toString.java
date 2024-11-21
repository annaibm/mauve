/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultBoundedRangeModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultBoundedRangeModel;

public class toString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Test dbrm = new Test();
        dbrm.setRangeProperties(3, 2, -4, 10, true);
        harness.check(dbrm.toString(), (Object)"gnu.testlet.javax.swing.DefaultBoundedRangeModel.toString$Test[value=3, extent=2, min=-4, max=10, adj=true]");
    }

    private static class Test
    extends DefaultBoundedRangeModel {
        private Test() {
        }
    }
}

