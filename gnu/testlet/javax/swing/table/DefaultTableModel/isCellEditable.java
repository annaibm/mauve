/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableModel;

public class isCellEditable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableModel m1 = new DefaultTableModel(2, 3);
        harness.check(m1.isCellEditable(-1, -1));
        harness.check(m1.isCellEditable(0, 0));
        harness.check(m1.isCellEditable(1, 1));
        harness.check(m1.isCellEditable(99, 99));
    }
}

