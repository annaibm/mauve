/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class getColumnCount
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        m1.addColumn(new TableColumn());
        m1.addColumn(new TableColumn());
        m1.addColumn(new TableColumn());
        harness.check(m1.getColumnCount(), 3);
    }
}

