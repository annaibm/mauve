/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableModel;

public class getRowCount
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableModel m1 = new DefaultTableModel(2, 3);
        harness.check(m1.getRowCount(), 2);
        m1.setRowCount(99);
        harness.check(m1.getRowCount(), 99);
    }
}

