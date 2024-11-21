/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultButtonModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultButtonModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class setRollover
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
        DefaultButtonModel m = new DefaultButtonModel();
        m.addActionListener(this);
        m.addChangeListener(this);
        m.setRollover(true);
        harness.check(m.isRollover(), true);
        harness.check(this.lastChangeEvent.getSource(), m);
        harness.check(this.lastActionEvent, null);
        this.lastChangeEvent = null;
        m.setRollover(true);
        harness.check(this.lastChangeEvent, null);
        m.setPressed(true);
        harness.check(m.isRollover(), true);
        m.setEnabled(false);
        harness.check(m.isRollover(), true);
        m.setEnabled(true);
        harness.check(m.isRollover(), true);
    }
}

