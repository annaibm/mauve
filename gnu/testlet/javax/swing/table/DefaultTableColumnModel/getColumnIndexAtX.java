/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class getColumnIndexAtX
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        TableColumn c0 = new TableColumn(0, 5);
        TableColumn c1 = new TableColumn(1, 7);
        TableColumn c2 = new TableColumn(2, 11);
        m1.addColumn(c0);
        m1.addColumn(c1);
        m1.addColumn(c2);
        harness.check(m1.getColumnIndexAtX(-1), -1);
        harness.check(m1.getColumnIndexAtX(0), 0);
        harness.check(m1.getColumnIndexAtX(5), 1);
        harness.check(m1.getColumnIndexAtX(11), 1);
        harness.check(m1.getColumnIndexAtX(12), 2);
        harness.check(m1.getColumnIndexAtX(22), 2);
        harness.check(m1.getColumnIndexAtX(23), -1);
        m1.setColumnMargin(3);
        harness.check(m1.getColumnIndexAtX(-1), -1);
        harness.check(m1.getColumnIndexAtX(0), 0);
        harness.check(m1.getColumnIndexAtX(5), 1);
        harness.check(m1.getColumnIndexAtX(11), 1);
        harness.check(m1.getColumnIndexAtX(12), 2);
        harness.check(m1.getColumnIndexAtX(22), 2);
        harness.check(m1.getColumnIndexAtX(23), -1);
    }
}

