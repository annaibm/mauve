/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.table.TableColumn;

public class properties
implements Testlet {
    Object changedProperty;

    @Override
    public void test(TestHarness harness) {
        TableColumn tc = new TableColumn();
        tc.addPropertyChangeListener(new TestPropertyListener());
        tc.setPreferredWidth(100);
        this.changedProperty = null;
        tc.setPreferredWidth(200);
        harness.check(this.changedProperty, "preferredWidth", "preferredWidth");
        tc.setWidth(100);
        this.changedProperty = null;
        tc.setWidth(200);
        harness.check(this.changedProperty, "width", "width");
    }

    class TestPropertyListener
    implements PropertyChangeListener {
        TestPropertyListener() {
        }

        @Override
        public void propertyChange(PropertyChangeEvent e) {
            properties.this.changedProperty = e.getPropertyName();
        }
    }
}

