/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class getColumnIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        TableColumn c0 = new TableColumn(0);
        TableColumn c1 = new TableColumn(1);
        TableColumn c2 = new TableColumn(2);
        c0.setIdentifier("A");
        c1.setIdentifier("B");
        c2.setIdentifier("C");
        m1.addColumn(c0);
        m1.addColumn(c1);
        m1.addColumn(c2);
        harness.check(m1.getColumnIndex("A"), 0);
        harness.check(m1.getColumnIndex("B"), 1);
        harness.check(m1.getColumnIndex("C"), 2);
        boolean pass = false;
        try {
            m1.getColumnIndex("D");
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.getColumnIndex(null);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

