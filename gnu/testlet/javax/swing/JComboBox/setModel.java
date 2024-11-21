/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComboBox.MyJComboBox;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

public class setModel
implements Testlet,
ItemListener,
ListDataListener {
    private List events = new ArrayList();

    @Override
    public void test(TestHarness harness) {
        MyJComboBox c = new MyJComboBox(new Object[]{"A", "B", "C"});
        harness.check(c.getSelectedItemReminder(), (Object)"A");
        c.setModel(new DefaultComboBoxModel<Object>(new Object[]{"W", "X", "Y", "Z"}));
        harness.check(c.getSelectedItemReminder(), (Object)"W");
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        this.events.add(e);
    }

    @Override
    public void intervalAdded(ListDataEvent e) {
        this.events.add(e);
    }

    @Override
    public void intervalRemoved(ListDataEvent e) {
        this.events.add(e);
    }

    @Override
    public void contentsChanged(ListDataEvent e) {
        this.events.add(e);
    }
}

