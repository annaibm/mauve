/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.AbstractTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableModel;

public class findColumn
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableModel m1 = new DefaultTableModel(new Object[]{"C1", "C2", "C3"}, 1);
        harness.check(m1.findColumn("C1"), 0);
        harness.check(m1.findColumn("C2"), 1);
        harness.check(m1.findColumn("C3"), 2);
        harness.check(m1.findColumn("C4"), -1);
        boolean pass = false;
        try {
            m1.findColumn(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

