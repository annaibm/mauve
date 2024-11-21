/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComboBox;

public class setPrototypeDisplayValue
implements Testlet,
PropertyChangeListener {
    private String name = null;
    private Object oldValue = null;
    private Object newValue = null;

    @Override
    public void test(TestHarness harness) {
        JComboBox<String> c = new JComboBox<String>();
        c.addPropertyChangeListener(this);
        c.setPrototypeDisplayValue("Test1");
        harness.check(c.getPrototypeDisplayValue(), (Object)"Test1");
        harness.check(this.name, (Object)"prototypeDisplayValue");
        harness.check(this.oldValue, null);
        harness.check(this.newValue, (Object)"Test1");
        c.setPrototypeDisplayValue("Test2");
        harness.check(c.getPrototypeDisplayValue(), (Object)"Test2");
        harness.check(this.name, (Object)"prototypeDisplayValue");
        harness.check(this.oldValue, (Object)"Test1");
        harness.check(this.newValue, (Object)"Test2");
        c.setPrototypeDisplayValue(null);
        harness.check(c.getPrototypeDisplayValue(), null);
        harness.check(this.name, (Object)"prototypeDisplayValue");
        harness.check(this.oldValue, (Object)"Test2");
        harness.check(this.newValue, null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.name = e.getPropertyName();
        this.oldValue = e.getOldValue();
        this.newValue = e.getNewValue();
    }
}

