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

public class setMnemonic
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
        m.setMnemonic(99);
        harness.check(m.getMnemonic(), 99);
        harness.check(this.lastChangeEvent.getSource(), m);
        harness.check(this.lastActionEvent, null);
        this.lastChangeEvent = null;
        m.setMnemonic(99);
        harness.check(this.lastChangeEvent, null);
        m.setMnemonic(Integer.MIN_VALUE);
        harness.check(m.getMnemonic(), Integer.MIN_VALUE);
    }
}

