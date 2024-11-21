/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JToggleButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class click
implements Testlet,
ActionListener,
ChangeListener {
    static String UNASSIGNED = "<unassigned>";
    static String LABEL = "label";
    String command;
    boolean ceCalled;
    boolean alCalled;

    @Override
    public void actionPerformed(ActionEvent e) {
        this.command = e.getActionCommand();
        this.alCalled = true;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.ceCalled = true;
    }

    @Override
    public void test(TestHarness harness) {
        JToggleButton b = this.createToggleButton(harness);
        this.testStateChanges(harness, b);
        this.testListeners(harness, b);
    }

    private void testListeners(TestHarness harness, JToggleButton b) {
        b.setSelected(false);
        b.addActionListener(this);
        b.addChangeListener(this);
        this.alCalled = false;
        b.doClick();
        harness.check(this.command, LABEL, "Notifying action listener about the programmatic click");
        harness.check(this.ceCalled, "Notifying change listener about the programmatic click");
        this.ceCalled = false;
        this.command = UNASSIGNED;
        b.setSelected(!b.isSelected());
        harness.check(this.ceCalled, "Notifying change listener after the call of setSelected(..)");
        harness.check(this.command, UNASSIGNED, "False message to the action listener after the call of setSelected(..)");
        this.ceCalled = false;
        this.command = UNASSIGNED;
        b.setSelected(b.isSelected());
        harness.check(!this.ceCalled, "The change listener should only be notified about the CHANGES. Bug in 1.3, fixed in 1.4.");
        this.command = UNASSIGNED;
        this.ceCalled = false;
        b.removeActionListener(this);
        b.removeChangeListener(this);
        b.doClick();
        harness.check(this.command, UNASSIGNED, "Removing action listener");
        harness.check(!this.ceCalled, "Removing change listener");
    }

    private void testStateChanges(TestHarness harness, JToggleButton b) {
        b.setSelected(false);
        b.doClick();
        harness.check(b.isSelected(), "state must alter to true after click");
        b.doClick();
        harness.check(!b.isSelected(), "state must alter to false after click");
        b.setSelected(true);
        harness.check(b.isSelected(), "manual state setting");
    }

    private JToggleButton createToggleButton(TestHarness harness) {
        JToggleButton b = new JToggleButton();
        b.setText(LABEL);
        harness.check(b.getText(), LABEL, LABEL);
        b.setToolTipText("tip");
        harness.check(b.getToolTipText(), "tip", "tooltip");
        harness.check(!b.isSelected(), "initial state");
        harness.check(b.isShowing(), false, "surely unvisible");
        harness.check(b.isOpaque(), true, "must be opaque by default");
        harness.check(b.getActionCommand(), LABEL, "getActionCommand");
        return b;
    }
}

