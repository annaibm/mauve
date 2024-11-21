/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableModel;

public class getColumnName
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableModel m1 = new DefaultTableModel(2, 53);
        harness.check(m1.getColumnName(0), (Object)"A");
        harness.check(m1.getColumnName(26), (Object)"AA");
        harness.check(m1.getColumnName(52), (Object)"BA");
        boolean pass = false;
        try {
            m1.getColumnName(-1);
        }
        catch (RuntimeException e) {
            pass = true;
        }
        harness.check(pass);
        harness.check(m1.getColumnName(99), (Object)"CV");
    }
}

