/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.ListDataEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.event.ListDataEvent;

public class getIndex0
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ListDataEvent e = new ListDataEvent(this, 2, 1, 2);
        harness.check(e.getIndex0(), 1);
        e = new ListDataEvent(this, 2, 4, 3);
        harness.check(e.getIndex0(), 3);
    }
}

