/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;

public class getColumn
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        TableColumn column = new TableColumn(1, 23);
        m1.addColumn(column);
        TableColumn c = m1.getColumn(0);
        harness.check(c, column);
        boolean pass = false;
        try {
            c = m1.getColumn(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            c = m1.getColumn(1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

