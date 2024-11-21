/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.table.DefaultTableColumnModel;

public class getSelectionModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        DefaultListSelectionModel lsm = new DefaultListSelectionModel();
        m1.setSelectionModel(lsm);
        harness.check(m1.getSelectionModel(), lsm);
    }
}

