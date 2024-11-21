/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultComboBoxModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class removeAllElements
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
        harness.check(m.getSize(), 3);
        harness.check(m.getSelectedItem(), (Object)"A");
        m.removeAllElements();
        harness.check(m.getSize(), 0);
        harness.check(m.getSelectedItem(), null);
        harness.check(this.eventType, 2);
        harness.check(this.index0, 0);
        harness.check(this.index1, 2);
        this.eventType = -1;
        this.index0 = -1;
        this.index1 = -1;
        m.removeAllElements();
        harness.check(m.getSize(), 0);
        harness.check(this.eventType, -1);
        harness.check(this.index0, -1);
        harness.check(this.index1, -1);
    }
}

