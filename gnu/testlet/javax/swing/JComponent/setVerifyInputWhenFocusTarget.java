/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class setVerifyInputWhenFocusTarget
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        JButton c = new JButton("ABC");
        harness.check(c.getVerifyInputWhenFocusTarget(), true);
        c.addPropertyChangeListener(this);
        c.setVerifyInputWhenFocusTarget(false);
        harness.check(c.getVerifyInputWhenFocusTarget(), false);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), c);
        harness.check(e0.getPropertyName(), (Object)"verifyInputWhenFocusTarget");
        harness.check(e0.getOldValue(), Boolean.TRUE);
        harness.check(e0.getNewValue(), Boolean.FALSE);
        this.events.clear();
        c.setVerifyInputWhenFocusTarget(false);
        harness.check(this.events.size(), 0);
    }
}

