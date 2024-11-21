/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.SpinnerNumberModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class setValue
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
        m.setValue(new Double(2.2));
        harness.check(m.getValue(), new Double(2.2));
        harness.check(this.event.getSource(), m);
        this.event = null;
        m.setValue(new Double(2.2));
        harness.check(this.event == null);
        m.setValue(new Double(-99.0));
        harness.check(m.getValue(), new Double(-99.0));
        m.setValue(new Double(99.0));
        harness.check(m.getValue(), new Double(99.0));
        boolean pass = false;
        try {
            m.setValue(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.setValue("123");
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

