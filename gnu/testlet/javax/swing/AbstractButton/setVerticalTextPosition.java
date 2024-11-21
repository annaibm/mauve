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

public class setVerticalTextPosition
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
        b.setVerticalTextPosition(1);
        harness.check(b.getVerticalTextPosition(), 1);
        PropertyChangeEvent e = (PropertyChangeEvent)this.events.get(0);
        harness.check(e.getSource(), b);
        harness.check(e.getPropertyName(), (Object)"verticalTextPosition");
        harness.check(e.getOldValue(), new Integer(0));
        harness.check(e.getNewValue(), new Integer(1));
        this.events.clear();
        b.setVerticalTextPosition(1);
        harness.check(this.events.size(), 0);
        boolean pass = false;
        try {
            b.setVerticalTextPosition(2);
        }
        catch (IllegalArgumentException ex) {
            pass = true;
        }
        harness.check(pass);
    }
}

