/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultBoundedRangeModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class getChangeListeners
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyListener l1 = new MyListener();
        DefaultBoundedRangeModel dbrm = new DefaultBoundedRangeModel();
        harness.check(dbrm.getChangeListeners().length == 0);
        dbrm.setRangeProperties(3, 2, 0, 10, false);
        harness.check(dbrm.getExtent(), 2);
    }

    private static class MyListener
    implements ChangeListener {
        private MyListener() {
        }

        @Override
        public void stateChanged(ChangeEvent e) {
        }
    }
}

