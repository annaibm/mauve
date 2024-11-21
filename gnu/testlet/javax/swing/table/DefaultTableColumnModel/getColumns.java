/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Enumeration;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class getColumns
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        Enumeration<TableColumn> e = m1.getColumns();
        harness.check(!e.hasMoreElements());
        TableColumn c0 = new TableColumn(0);
        TableColumn c1 = new TableColumn(1);
        TableColumn c2 = new TableColumn(2);
        c0.setIdentifier("A");
        c1.setIdentifier("B");
        c2.setIdentifier("C");
        m1.addColumn(c0);
        m1.addColumn(c1);
        m1.addColumn(c2);
        e = m1.getColumns();
        TableColumn c = e.nextElement();
        harness.check(c.getIdentifier(), (Object)"A");
        c = e.nextElement();
        harness.check(c.getIdentifier(), (Object)"B");
        c = e.nextElement();
        harness.check(c.getIdentifier(), (Object)"C");
        harness.check(!e.hasMoreElements());
    }
}

