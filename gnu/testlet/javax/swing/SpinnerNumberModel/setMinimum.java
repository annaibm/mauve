/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SpinnerNumberModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class setMinimum
implements Testlet,
ChangeListener {
    private ChangeEvent event;

    @Override
    public void stateChanged(ChangeEvent e) {
        this.event = e;
    }

    @Override
    public void test(TestHarness harness) {
        SpinnerNumberModel m = new SpinnerNumberModel(2.0, 1.0, 3.0, 0.5);
        m.addChangeListener(this);
        m.setMinimum(new Double(0.7));
        harness.check(m.getMinimum(), new Double(0.7));
        harness.check(this.event.getSource(), m);
        this.event = null;
        m.setMinimum(new Double(0.7));
        harness.check(this.event == null);
        this.event = null;
        m.setMinimum(null);
        harness.check(m.getMinimum(), null);
        harness.check(this.event.getSource(), m);
        this.event = null;
        m.setMinimum(null);
        harness.check(this.event == null);
        m.setMinimum(new Double(99.0));
        harness.check(m.getMinimum(), new Double(99.0));
    }
}

