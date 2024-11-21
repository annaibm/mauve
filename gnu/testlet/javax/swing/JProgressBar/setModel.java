/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JProgressBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class setModel
implements Testlet,
ChangeListener {
    ChangeEvent lastEvent;

    @Override
    public void stateChanged(ChangeEvent e) {
        this.lastEvent = e;
    }

    @Override
    public void test(TestHarness harness) {
        DefaultBoundedRangeModel m1 = new DefaultBoundedRangeModel(1, 2, 0, 10);
        JProgressBar pb = new JProgressBar(m1);
        pb.addChangeListener(this);
        harness.check(m1.getExtent(), 0);
        harness.check(m1.getChangeListeners().length, 1);
        DefaultBoundedRangeModel m2 = new DefaultBoundedRangeModel(10, 20, 0, 100);
        pb.setModel(m2);
        harness.check(pb.getModel(), m2);
        harness.check(m2.getExtent(), 0);
        harness.check(m1.getChangeListeners().length, 0);
        harness.check(m2.getChangeListeners().length, 1);
        harness.check(this.lastEvent.getSource(), pb);
        boolean pass = false;
        try {
            pb.setModel(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

