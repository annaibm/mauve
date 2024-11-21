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

public class setSelectedIndex
implements Testlet,
ItemListener {
    private List events = new ArrayList();

    @Override
    public void test(TestHarness harness) {
        MyJComboBox c = new MyJComboBox(new Object[]{"A", "B", "C"});
        harness.check(c.getSelectedItemReminder(), (Object)"A");
        c.addItemListener(this);
        c.setSelectedIndex(1);
        harness.check(c.getSelectedItem(), (Object)"B");
        harness.check(this.events.size(), 2);
        ItemEvent e1 = (ItemEvent)this.events.get(0);
        harness.check(e1.getStateChange(), 2);
        harness.check(e1.getItem(), (Object)"A");
        ItemEvent e2 = (ItemEvent)this.events.get(1);
        harness.check(e2.getStateChange(), 1);
        harness.check(e2.getItem(), (Object)"B");
        this.events.clear();
        c.setSelectedIndex(-1);
        harness.check(this.events.size(), 1);
        e1 = (ItemEvent)this.events.get(0);
        harness.check(e1.getStateChange(), 2);
        harness.check(e1.getItem(), (Object)"B");
        this.events.clear();
        c.setSelectedIndex(-1);
        harness.check(this.events.size(), 0);
        c.setSelectedIndex(1);
        this.events.clear();
        c.setSelectedIndex(1);
        harness.check(this.events.size(), 0);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        this.events.add(e);
    }
}

