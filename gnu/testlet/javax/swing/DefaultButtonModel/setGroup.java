/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultButtonModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class setGroup
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
        ButtonGroup bg = new ButtonGroup();
        m.setGroup(bg);
        harness.check(m.getGroup(), bg);
        harness.check(this.lastChangeEvent, null);
        harness.check(this.lastActionEvent, null);
        harness.check(bg.getButtonCount(), 0);
        this.lastChangeEvent = null;
        m.setGroup(bg);
        harness.check(this.lastChangeEvent, null);
        m.setGroup(null);
        harness.check(m.getGroup(), null);
        harness.check(this.lastChangeEvent, null);
    }
}

