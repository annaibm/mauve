/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;

public class setLayoutOrientation
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        JList list2 = new JList();
        list2.addPropertyChangeListener(this);
        harness.check(list2.getLayoutOrientation(), 0);
        list2.setLayoutOrientation(2);
        harness.check(list2.getLayoutOrientation(), 2);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getSource(), list2);
        harness.check(e0.getPropertyName(), (Object)"layoutOrientation");
        harness.check(e0.getOldValue(), new Integer(0));
        harness.check(e0.getNewValue(), new Integer(2));
        this.events.clear();
        list2.setLayoutOrientation(2);
        harness.check(this.events.size(), 0);
        boolean pass = false;
        try {
            list2.setLayoutOrientation(99);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

