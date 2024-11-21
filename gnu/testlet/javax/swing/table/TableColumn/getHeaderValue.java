/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.TableColumn;

public class getHeaderValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        c.setHeaderValue(new Integer(99));
        harness.check(c.getHeaderValue(), new Integer(99));
    }
}

