/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JScrollBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;
import javax.accessibility.AccessibleValue;
import javax.swing.JScrollBar;

public class getAccessibleContext
implements Testlet,
PropertyChangeListener {
    List events = new ArrayList();

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.events.add(e);
    }

    @Override
    public void test(TestHarness harness) {
        JScrollBar scrollBar = new JScrollBar(0, 50, 5, 10, 90);
        AccessibleContext ac = scrollBar.getAccessibleContext();
        harness.check(ac.getAccessibleName(), null);
        harness.check(ac.getAccessibleRole(), AccessibleRole.SCROLL_BAR);
        harness.check(ac.getAccessibleAction(), null);
        harness.check(ac.getAccessibleComponent(), ac);
        harness.check(ac.getAccessibleDescription(), null);
        harness.check(ac.getAccessibleEditableText(), null);
        harness.check(ac.getAccessibleIcon(), null);
        harness.check(ac.getAccessibleTable(), null);
        harness.check(ac.getAccessibleText(), null);
        AccessibleValue av = ac.getAccessibleValue();
        harness.check(av, ac);
        harness.check(av.getCurrentAccessibleValue(), new Integer(50));
        harness.check(av.getMinimumAccessibleValue(), new Integer(10));
        harness.check(av.getMaximumAccessibleValue(), new Integer(85));
        ac.addPropertyChangeListener(this);
        boolean b = av.setCurrentAccessibleValue(new Integer(55));
        harness.check(scrollBar.getValue(), 55);
        harness.check(b);
        harness.check(this.events.size(), 1);
        PropertyChangeEvent e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getPropertyName(), (Object)"AccessibleValue");
        harness.check(e0.getSource(), ac);
        harness.check(e0.getOldValue(), new Integer(50));
        harness.check(e0.getNewValue(), new Integer(55));
        this.events.clear();
        b = av.setCurrentAccessibleValue(new Integer(5));
        harness.check(av.getCurrentAccessibleValue(), new Integer(10));
        harness.check(b);
        harness.check(this.events.size(), 1);
        e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getPropertyName(), (Object)"AccessibleValue");
        harness.check(e0.getSource(), ac);
        harness.check(e0.getOldValue(), new Integer(55));
        harness.check(e0.getNewValue(), new Integer(10));
        this.events.clear();
        b = av.setCurrentAccessibleValue(new Integer(105));
        harness.check(av.getCurrentAccessibleValue(), new Integer(85));
        harness.check(b);
        harness.check(this.events.size(), 1);
        e0 = (PropertyChangeEvent)this.events.get(0);
        harness.check(e0.getPropertyName(), (Object)"AccessibleValue");
        harness.check(e0.getSource(), ac);
        harness.check(e0.getOldValue(), new Integer(10));
        harness.check(e0.getNewValue(), new Integer(85));
        this.events.clear();
        b = av.setCurrentAccessibleValue(null);
        harness.check(av.getCurrentAccessibleValue(), new Integer(85));
        harness.check(this.events.size(), 0);
        harness.check(!b);
        AccessibleStateSet set2 = ac.getAccessibleStateSet();
        harness.check(set2.contains(AccessibleState.ENABLED));
        harness.check(set2.contains(AccessibleState.FOCUSABLE));
        harness.check(set2.contains(AccessibleState.VISIBLE));
        harness.check(set2.contains(AccessibleState.OPAQUE));
        harness.check(set2.contains(AccessibleState.HORIZONTAL));
        AccessibleStateSet set22 = ac.getAccessibleStateSet();
        harness.check(set2 != set22);
        scrollBar.setOrientation(1);
        set2 = ac.getAccessibleStateSet();
        harness.check(set2.contains(AccessibleState.VERTICAL));
    }
}

