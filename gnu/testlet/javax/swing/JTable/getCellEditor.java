/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JTable;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JTable;

public class getCellEditor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JTable table2 = new JTable();
        harness.check(table2.getCellEditor(), null);
    }
}

