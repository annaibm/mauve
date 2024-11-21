/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultBoundedRangeModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class setValueIsAdjusting
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyListener ml = new MyListener();
        DefaultBoundedRangeModel dbrm = new DefaultBoundedRangeModel();
        dbrm.addChangeListener(ml);
        harness.check(!dbrm.getValueIsAdjusting());
        dbrm.setValueIsAdjusting(true);
        harness.check(dbrm.getValueIsAdjusting());
        dbrm.setMaximum(5);
        harness.check(ml.wasAdjusting);
        dbrm.setValueIsAdjusting(false);
        harness.check(!dbrm.getValueIsAdjusting());
        dbrm.setValue(2);
        harness.check(!ml.wasAdjusting);
    }

    static class MyListener
    implements ChangeListener {
        public boolean wasAdjusting = false;

        MyListener() {
        }

        @Override
        public void stateChanged(ChangeEvent evt) {
            this.wasAdjusting = ((BoundedRangeModel)evt.getSource()).getValueIsAdjusting();
        }
    }
}

