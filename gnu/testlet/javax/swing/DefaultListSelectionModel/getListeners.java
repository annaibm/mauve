/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListSelectionModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class getListeners
implements Testlet,
ListSelectionListener {
    @Override
    public void valueChanged(ListSelectionEvent e) {
    }

    @Override
    public void test(TestHarness harness) {
        DefaultListSelectionModel m = new DefaultListSelectionModel();
        ListSelectionListener[] listeners = (ListSelectionListener[])m.getListeners(ListSelectionListener.class);
        harness.check(listeners.length, 0);
        m.addListSelectionListener(this);
        listeners = (ListSelectionListener[])m.getListeners(ListSelectionListener.class);
        harness.check(listeners[0], this);
    }
}

