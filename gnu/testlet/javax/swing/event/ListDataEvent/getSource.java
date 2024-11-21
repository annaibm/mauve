/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.event.ListDataEvent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.event.ListDataEvent;

public class getSource
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ListDataEvent e = new ListDataEvent(this, 2, 1, 2);
        harness.check(e.getSource(), this);
    }
}

