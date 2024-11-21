/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultButtonModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.DefaultButtonModel.MyDefaultButtonModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultButtonModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class setPressed
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
        this.testGeneral(harness);
        this.testEvent(harness);
    }

    public void testGeneral(TestHarness harness) {
        harness.checkPoint("testGeneral");
        MyDefaultButtonModel m = new MyDefaultButtonModel();
        m.addActionListener(this);
        m.addChangeListener(this);
        m.setPressed(true);
        harness.check(m.isPressed());
        harness.check(m.getStateMask(), 12);
        harness.check(this.lastChangeEvent.getSource(), m);
        harness.check(this.lastActionEvent, null);
        this.lastChangeEvent = null;
        m.setPressed(true);
        harness.check(this.lastChangeEvent, null);
        m.setEnabled(false);
        harness.check(m.isPressed(), false);
        harness.check(m.getStateMask(), 0);
        m.setEnabled(true);
        harness.check(m.isPressed(), false);
        harness.check(m.getStateMask(), 8);
        m.setEnabled(false);
        m.setPressed(true);
        harness.check(m.isPressed(), false);
        harness.check(m.getStateMask(), 0);
    }

    public void testEvent(TestHarness harness) {
        harness.checkPoint("testEvent");
        DefaultButtonModel m = new DefaultButtonModel();
        m.addActionListener(this);
        m.addChangeListener(this);
        this.lastActionEvent = null;
        m.setActionCommand("ABC");
        m.setArmed(true);
        harness.check(this.lastActionEvent, null);
        m.setPressed(true);
        this.lastChangeEvent = null;
        harness.check(this.lastActionEvent, null);
        m.setPressed(false);
        harness.check(this.lastActionEvent.getSource(), m);
        harness.check(this.lastActionEvent.getActionCommand(), (Object)"ABC");
        harness.check(this.lastChangeEvent.getSource(), m);
    }
}

