/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableColumnModel;

public class setSelectionModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        DefaultListSelectionModel lsm = new DefaultListSelectionModel();
        m1.setSelectionModel(lsm);
        harness.check(m1.getSelectionModel(), lsm);
        ListSelectionListener[] listeners = lsm.getListSelectionListeners();
        harness.check(listeners[0], m1);
        DefaultListSelectionModel lsm2 = new DefaultListSelectionModel();
        m1.setSelectionModel(lsm2);
        harness.check(m1.getSelectionModel(), lsm2);
        listeners = lsm.getListSelectionListeners();
        harness.check(listeners.length, 0);
        boolean pass = false;
        try {
            m1.setSelectionModel(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

