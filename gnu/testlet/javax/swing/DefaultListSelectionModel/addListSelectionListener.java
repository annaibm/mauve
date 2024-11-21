/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class addListSelectionListener
implements Testlet,
ListSelectionListener {
    @Override
    public void valueChanged(ListSelectionEvent e) {
    }

    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        m.addListSelectionListener(this);
        harness.check(m.getListSelectionListeners().length, 1);
        harness.check(m.getListSelectionListeners()[0], this);
        m.addListSelectionListener(null);
        harness.check(m.getListSelectionListeners().length, 1);
        harness.check(m.getListSelectionListeners()[0], this);
    }
}

