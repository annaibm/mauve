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

public class setVerticalAlignment
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
        b.setVerticalAlignment(3);
        harness.check(b.getVerticalAlignment(), 3);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getSource(), b);
        harness.check(e.getPropertyName(), (Object)"verticalAlignment");
        harness.check(e.getOldValue(), new Integer(0));
        harness.check(e.getNewValue(), new Integer(3));
        this.events.clear();
        b.setVerticalAlignment(3);
        harness.check(this.events.size(), 0);
        boolean pass = false;
        try {
            b.setVerticalAlignment(4);
        }
        catch (IllegalArgumentException ex) {
            pass = true;
        }
        harness.check(pass);
    }
}

