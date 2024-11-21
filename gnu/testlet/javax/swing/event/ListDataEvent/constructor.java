/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.ListDataEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.event.ListDataEvent;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ListDataEvent e = new ListDataEvent(this, 0, 1, 2);
        harness.check(e.getSource(), this);
        harness.check(e.getType(), 0);
        harness.check(e.getIndex0(), 1);
        harness.check(e.getIndex1(), 2);
        boolean pass = false;
        try {
            e = new ListDataEvent(null, 0, 1, 2);
        }
        catch (IllegalArgumentException ex) {
            pass = true;
        }
        harness.check(pass);
        e = new ListDataEvent(this, 0, 99, 2);
        harness.check(e.getIndex0(), 2);
        harness.check(e.getIndex1(), 99);
        e = new ListDataEvent(this, -99, 1, 2);
        harness.check(e.getType(), -99);
        e = new ListDataEvent(this, 0, -10, 2);
        harness.check(e.getIndex0(), -10);
        harness.check(e.getIndex1(), 2);
        e = new ListDataEvent(this, 0, 1, -2);
        harness.check(e.getIndex0(), -2);
        harness.check(e.getIndex1(), 1);
    }
}

