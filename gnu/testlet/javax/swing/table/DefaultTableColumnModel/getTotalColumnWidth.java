/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class getTotalColumnWidth
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m = new DefaultTableColumnModel();
        harness.check(m.getTotalColumnWidth(), 0);
        TableColumn c1 = new TableColumn(0, 9);
        m.addColumn(c1);
        harness.check(m.getTotalColumnWidth(), 9);
        TableColumn c2 = new TableColumn(1, 12);
        m.addColumn(c2);
        harness.check(m.getTotalColumnWidth(), 21);
        m.setColumnMargin(5);
        harness.check(m.getTotalColumnWidth(), 21);
        c1.setWidth(99);
        harness.check(m.getTotalColumnWidth(), 111);
    }
}

