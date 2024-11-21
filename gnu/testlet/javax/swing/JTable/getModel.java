/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class getModel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getModel()");
        DefaultTableModel m1 = new DefaultTableModel();
        JTable t = new JTable(m1);
        harness.check(t.getModel() == m1);
        DefaultTableModel m2 = new DefaultTableModel();
        t.setModel(m2);
        harness.check(t.getModel() == m2);
    }
}

