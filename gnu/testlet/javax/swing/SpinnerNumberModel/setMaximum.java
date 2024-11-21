/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SpinnerNumberModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class setMaximum
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
        m.setMaximum(new Double(3.7));
        harness.check(m.getMaximum(), new Double(3.7));
        harness.check(this.event.getSource(), m);
        this.event = null;
        m.setMaximum(new Double(3.7));
        harness.check(this.event == null);
        this.event = null;
        m.setMaximum(null);
        harness.check(m.getMaximum(), null);
        harness.check(this.event.getSource(), m);
        this.event = null;
        m.setMaximum(null);
        harness.check(this.event == null);
        m.setMaximum(new Double(-99.0));
        harness.check(m.getMaximum(), new Double(-99.0));
    }
}

