/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class getSelectedColumnCount
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        harness.check(m1.getSelectedColumnCount(), 0);
        m1.addColumn(new TableColumn());
        m1.addColumn(new TableColumn());
        m1.addColumn(new TableColumn());
        m1.getSelectionModel().setSelectionInterval(1, 2);
        harness.check(m1.getSelectedColumnCount(), 2);
    }
}

