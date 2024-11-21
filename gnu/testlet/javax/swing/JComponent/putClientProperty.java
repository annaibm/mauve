/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JLabel;

public class putClientProperty
implements Testlet,
PropertyChangeListener {
    public String name = null;
    public Object oldValue = null;
    public Object newValue = null;

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.name = e.getPropertyName();
        this.oldValue = e.getOldValue();
        this.newValue = e.getNewValue();
    }

    @Override
    public void test(TestHarness harness) {
        JLabel label = new JLabel("Test");
        label.addPropertyChangeListener(this);
        label.putClientProperty("Property1", Boolean.TRUE);
        harness.check(label.getClientProperty("Property1"), Boolean.TRUE);
        harness.check(this.name, (Object)"Property1");
        harness.check(this.oldValue, null);
        harness.check(this.newValue, Boolean.TRUE);
        label.putClientProperty("testnull", null);
        this.name = null;
        this.oldValue = null;
        this.newValue = null;
        label.putClientProperty("testnull", null);
        harness.check(this.name, null);
        harness.check(this.oldValue, null);
        harness.check(this.newValue, null);
        label.putClientProperty("Property1", Boolean.FALSE);
        harness.check(label.getClientProperty("Property1"), Boolean.FALSE);
        harness.check(this.name, (Object)"Property1");
        harness.check(this.oldValue, Boolean.TRUE);
        harness.check(this.newValue, Boolean.FALSE);
        label.putClientProperty("Property1", null);
        harness.check(label.getClientProperty("Property1"), null);
        harness.check(this.name, (Object)"Property1");
        harness.check(this.oldValue, Boolean.FALSE);
        harness.check(this.newValue, null);
        boolean pass = false;
        try {
            label.putClientProperty(null, "XYZ");
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

