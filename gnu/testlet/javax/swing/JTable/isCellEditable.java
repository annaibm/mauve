/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class isCellEditable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("isCellEditable()");
        DefaultTableModel m1 = new DefaultTableModel(4, 6){

            @Override
            public boolean isCellEditable(int row, int column) {
                return row > 1 && column > 2;
            }
        };
        JTable t = new JTable(m1);
        harness.check(!t.isCellEditable(0, 0));
        harness.check(t.isCellEditable(2, 3));
        harness.check(!t.isCellEditable(-1, 0));
        harness.check(!t.isCellEditable(0, -1));
        harness.check(!t.isCellEditable(999, 0));
        boolean pass = false;
        try {
            t.isCellEditable(0, 999);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

