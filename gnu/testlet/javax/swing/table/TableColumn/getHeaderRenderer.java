/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

public class getHeaderRenderer
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        c.setHeaderRenderer(r);
        harness.check(c.getHeaderRenderer(), r);
    }
}

