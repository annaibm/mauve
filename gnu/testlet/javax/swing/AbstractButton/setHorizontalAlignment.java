/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

public class setHorizontalAlignment
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        JButton b = new JButton("ABC");
        b.addPropertyChangeListener(this);
        b.setHorizontalAlignment(4);
        harness.check(b.getHorizontalAlignment(), 4);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getSource(), b);
        harness.check(e.getPropertyName(), (Object)"horizontalAlignment");
        harness.check(e.getOldValue(), new Integer(0));
        harness.check(e.getNewValue(), new Integer(4));
        this.events.clear();
        b.setHorizontalAlignment(4);
        harness.check(this.events.size(), 0);
        boolean pass = false;
        try {
            b.setHorizontalAlignment(1);
        }
        catch (IllegalArgumentException ex) {
            pass = true;
        }
        harness.check(pass);
    }
}

