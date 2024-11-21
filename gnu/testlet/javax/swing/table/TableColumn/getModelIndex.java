/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.TableColumn;

public class getModelIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        c.setModelIndex(99);
        harness.check(c.getModelIndex(), 99);
    }
}

