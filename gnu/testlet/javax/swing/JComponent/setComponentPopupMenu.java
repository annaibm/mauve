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
import javax.swing.JPopupMenu;

public class setComponentPopupMenu
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
        JPopupMenu p = new JPopupMenu();
        harness.check(c.getComponentPopupMenu(), null);
        c.addPropertyChangeListener(this);
        c.setComponentPopupMenu(p);
        harness.check(c.getComponentPopupMenu(), p);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getSource(), c);
        harness.check(e.getPropertyName(), (Object)"componentPopupMenu");
        harness.check(e.getOldValue(), null);
        harness.check(e.getNewValue(), p);
        this.events.clear();
        c.setComponentPopupMenu(p);
        harness.check(this.events.size(), 0);
    }
}

