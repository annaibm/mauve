/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class getCellRenderer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        c.setCellRenderer(r);
        harness.check(c.getCellRenderer(), r);
    }
}

