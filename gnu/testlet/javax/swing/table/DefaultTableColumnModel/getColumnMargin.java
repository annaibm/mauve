/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.DefaultTableColumnModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.DefaultTableColumnModel;

public class getColumnMargin
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        DefaultTableColumnModel m1 = new DefaultTableColumnModel();
        harness.check(m1.getColumnMargin(), 1);
        m1.setColumnMargin(123);
        harness.check(m1.getColumnMargin(), 123);
    }
}

