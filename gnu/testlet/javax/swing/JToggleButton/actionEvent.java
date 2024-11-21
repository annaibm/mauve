/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JToggleButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

public class actionEvent
implements Testlet,
ActionListener {
    boolean alNotified = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        this.alNotified = true;
    }

    @Override
    public void test(TestHarness harness) {
        JToggleButton b = new JToggleButton();
        b.addActionListener(this);
        this.testProgrammaticChanges(harness, b);
        this.testUserChanges(harness, b);
    }

    void testProgrammaticChanges(TestHarness harness, JToggleButton b) {
        b.setSelected(false);
        this.alNotified = false;
        b.setSelected(false);
        harness.check(this.alNotified, false, "Should not be notified on programmatic state change");
        this.alNotified = false;
        b.setSelected(true);
        harness.check(this.alNotified, false, "Should not be notified on programmatic state change");
        this.alNotified = false;
        b.setSelected(true);
        harness.check(this.alNotified, false, "Should not be notified on programmatic state change");
        this.alNotified = false;
        b.setSelected(false);
        harness.check(this.alNotified, false, "Should not be notified on programmatic state change");
    }

    void testUserChanges(TestHarness harness, JToggleButton b) {
        b.setSelected(false);
        this.alNotified = false;
        b.doClick();
        harness.check(this.alNotified, true, "Should be notified on user click");
        this.alNotified = false;
        b.doClick();
        harness.check(this.alNotified, true, "Should be notified on user click");
    }
}

