/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultComboBoxModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class insertElementAt
implements Testlet,
ListDataListener {
    int index0;
    int index1;
    int eventType;

    @Override
    public void contentsChanged(ListDataEvent event) {
        this.eventType = event.getType();
        this.index0 = event.getIndex0();
        this.index1 = event.getIndex1();
    }

    @Override
    public void intervalAdded(ListDataEvent event) {
        this.eventType = event.getType();
        this.index0 = event.getIndex0();
        this.index1 = event.getIndex1();
    }

    @Override
    public void intervalRemoved(ListDataEvent event) {
        this.eventType = event.getType();
        this.index0 = event.getIndex0();
        this.index1 = event.getIndex1();
    }

    @Override
    public void test(TestHarness harness) {
        DefaultComboBoxModel<String> m = new DefaultComboBoxModel<String>();
        m.addListDataListener(this);
        m.insertElementAt("A", 0);
        harness.check(m.getSize(), 1);
        harness.check(m.getElementAt(0), (Object)"A");
        harness.check(m.getSelectedItem(), null);
        harness.check(this.eventType, 1);
        harness.check(this.index0, 0);
        harness.check(this.index1, 0);
        m.insertElementAt("B", 1);
        harness.check(m.getSize(), 2);
        harness.check(m.getElementAt(1), (Object)"B");
        harness.check(m.getSelectedItem(), null);
        harness.check(this.eventType, 1);
        harness.check(this.index0, 1);
        harness.check(this.index1, 1);
        m.insertElementAt("C", 0);
        harness.check(m.getSize(), 3);
        harness.check(m.getElementAt(0), (Object)"C");
        harness.check(m.getSelectedItem(), null);
        harness.check(this.eventType, 1);
        harness.check(this.index0, 0);
        harness.check(this.index1, 0);
        m.insertElementAt(null, 0);
        harness.check(m.getSize(), 4);
        harness.check(m.getElementAt(0), null);
        harness.check(m.getSelectedItem(), null);
        harness.check(this.eventType, 1);
        harness.check(this.index0, 0);
        harness.check(this.index1, 0);
        boolean pass = true;
        try {
            m.insertElementAt("Z", -1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.insertElementAt("Z", 5);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

