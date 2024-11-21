/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import javax.swing.JButton;

public class addVetoableChangeListener
implements Testlet,
VetoableChangeListener {
    @Override
    public void vetoableChange(PropertyChangeEvent e) throws PropertyVetoException {
    }

    @Override
    public void test(TestHarness harness) {
        JButton c = new JButton("ABC");
        harness.check(c.getVetoableChangeListeners().length, 0);
        c.addVetoableChangeListener(this);
        harness.check(c.getVetoableChangeListeners().length, 1);
        c.addVetoableChangeListener(null);
        harness.check(c.getVetoableChangeListeners().length, 1);
    }
}

