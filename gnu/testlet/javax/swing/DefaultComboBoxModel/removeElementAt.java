/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultComboBoxModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class removeElementAt
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
        DefaultComboBoxModel<Object> m = new DefaultComboBoxModel<Object>(new Object[]{"A", "B", "C"});
        m.addListDataListener(this);
        m.removeElementAt(0);
        harness.check(m.getSize(), 2);
        harness.check(m.getElementAt(0), (Object)"B");
        harness.check(m.getSelectedItem(), (Object)"B");
        harness.check(this.eventType, 2);
        harness.check(this.index0, 0);
        harness.check(this.index1, 0);
        m.removeElementAt(1);
        harness.check(m.getSize(), 1);
        harness.check(m.getElementAt(0), (Object)"B");
        harness.check(m.getSelectedItem(), (Object)"B");
        harness.check(this.eventType, 2);
        harness.check(this.index0, 1);
        harness.check(this.index1, 1);
        boolean pass = false;
        try {
            m.removeElementAt(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m.removeElementAt(1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        m = new DefaultComboBoxModel<Object>(new Object[]{"A", "B", "C"});
        m.setSelectedItem("B");
        m.removeElementAt(1);
        harness.check(m.getSelectedItem(), (Object)"A");
    }
}

