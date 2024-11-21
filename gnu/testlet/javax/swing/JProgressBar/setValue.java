/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JProgressBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JProgressBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class setValue
implements Testlet,
ChangeListener {
    List events = new ArrayList();

    @Override
    public void stateChanged(ChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        DefaultBoundedRangeModel m = new DefaultBoundedRangeModel();
        m.addChangeListener(this);
        JProgressBar pb = new JProgressBar(m);
        pb.addChangeListener(this);
        harness.check(pb.getValue(), 0);
        pb.setValue(55);
        harness.check(pb.getValue(), 55);
        harness.check(m.getValue(), 55);
        harness.check(this.events.size(), 2);
        this.events.clear();
        pb.setValue(55);
        harness.check(this.events.size(), 0);
        this.events.clear();
        pb.setValue(-1);
        harness.check(pb.getValue(), 0);
        harness.check(m.getValue(), 0);
        harness.check(this.events.size(), 2);
        this.events.clear();
        pb.setValue(101);
        harness.check(pb.getValue(), 100);
        harness.check(m.getValue(), 100);
        harness.check(this.events.size(), 2);
    }
}

