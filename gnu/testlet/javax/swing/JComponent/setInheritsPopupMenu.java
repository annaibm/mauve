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
import javax.swing.JComponent;
import javax.swing.JLabel;

public class setInheritsPopupMenu
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        JComponent c = new JButton("ABC");
        harness.check(c.getInheritsPopupMenu(), false);
        c.addPropertyChangeListener(this);
        c.setInheritsPopupMenu(true);
        harness.check(c.getInheritsPopupMenu(), true);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getSource(), c);
        harness.check(e.getPropertyName(), (Object)"inheritsPopupMenu");
        harness.check(e.getOldValue(), Boolean.FALSE);
        harness.check(e.getNewValue(), Boolean.TRUE);
        this.events.clear();
        c.setInheritsPopupMenu(true);
        harness.check(this.events.size(), 0);
        c = new JLabel("XYZ");
        harness.check(c.getInheritsPopupMenu(), true);
        c.addPropertyChangeListener(this);
        c.setInheritsPopupMenu(false);
        harness.check(c.getInheritsPopupMenu(), false);
        harness.check(this.events.size(), 1);
        e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getSource(), c);
        harness.check(e.getPropertyName(), (Object)"inheritsPopupMenu");
        harness.check(e.getOldValue(), Boolean.TRUE);
        harness.check(e.getNewValue(), Boolean.FALSE);
    }
}

