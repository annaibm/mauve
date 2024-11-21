/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.table.TableColumn;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.table.TableColumn;

public class getIdentifier
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TableColumn c = new TableColumn();
        c.setIdentifier(new Integer(99));
        harness.check(c.getIdentifier(), new Integer(99));
        c.setIdentifier(null);
        c.setHeaderValue("Test");
        harness.check(c.getIdentifier(), (Object)"Test");
    }
}

