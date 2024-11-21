/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultButtonModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultButtonModel.MyDefaultButtonModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class setEnabled
implements Testlet,
ActionListener,
ChangeListener {
    ChangeEvent lastChangeEvent;
    ActionEvent lastActionEvent;

    @Override
    public void stateChanged(ChangeEvent e) {
        this.lastChangeEvent = e;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.lastActionEvent = e;
    }

    @Override
    public void test(TestHarness harness) {
        MyDefaultButtonModel m = new MyDefaultButtonModel();
        m.addActionListener(this);
        m.addChangeListener(this);
        m.setEnabled(false);
        harness.check(m.isEnabled(), false);
        harness.check(m.getStateMask(), 0);
        harness.check(this.lastChangeEvent.getSource(), m);
        harness.check(this.lastActionEvent, null);
        this.lastChangeEvent = null;
        m.setEnabled(false);
        harness.check(m.getStateMask(), 0);
        harness.check(this.lastChangeEvent, null);
        m.setEnabled(true);
        harness.check(m.getStateMask(), 8);
        harness.check(this.lastChangeEvent.getSource(), m);
        m.setArmed(true);
        harness.check(m.getStateMask(), 9);
        m.setEnabled(false);
        harness.check(m.getStateMask(), 0);
    }
}

