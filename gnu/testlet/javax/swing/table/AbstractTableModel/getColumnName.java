/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.AbstractTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.table.AbstractTableModel.MyTableModel;

public class getColumnName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyTableModel m1 = new MyTableModel();
        harness.check(m1.getColumnName(0), (Object)"A");
        harness.check(m1.getColumnName(1), (Object)"B");
        harness.check(m1.getColumnName(26), (Object)"AA");
        harness.check(m1.getColumnName(27), (Object)"AB");
        harness.check(m1.getColumnName(-1), (Object)"");
        harness.check(m1.getColumnName(Integer.MIN_VALUE), (Object)"");
        harness.check(m1.getColumnName(0x7FFFFFFE), (Object)"FXSHRXW");
        harness.check(m1.getColumnName(Integer.MAX_VALUE), (Object)"FXSHRXX");
    }
}

