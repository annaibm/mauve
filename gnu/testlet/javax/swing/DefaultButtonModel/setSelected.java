/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultButtonModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultButtonModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class setSelected
implements Testlet,
ActionListener,
ChangeListener,
ItemListener {
    ChangeEvent lastChangeEvent;
    ActionEvent lastActionEvent;
    ItemEvent lastItemEvent;

    @Override
    public void stateChanged(ChangeEvent e) {
        this.lastChangeEvent = e;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.lastActionEvent = e;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        this.lastItemEvent = e;
    }

    @Override
    public void test(TestHarness harness) {
        DefaultButtonModel m = new DefaultButtonModel();
        m.addActionListener(this);
        m.addChangeListener(this);
        m.addItemListener(this);
        m.setSelected(true);
        harness.check(m.isSelected(), true);
        harness.check(this.lastChangeEvent.getSource(), m);
        harness.check(this.lastActionEvent, null);
        harness.check(this.lastItemEvent.getSource(), m);
        harness.check(this.lastItemEvent.getItem(), m);
        this.lastChangeEvent = null;
        this.lastItemEvent = null;
        m.setSelected(true);
        harness.check(this.lastChangeEvent, null);
        harness.check(this.lastItemEvent, null);
        m.setPressed(true);
        harness.check(m.isSelected(), true);
        m.setEnabled(false);
        harness.check(m.isSelected(), true);
        m.setEnabled(true);
        harness.check(m.isSelected(), true);
    }
}

