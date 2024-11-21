/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;

public class ensureCapacity
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("ensureCapacity()");
        DefaultListModel m1 = new DefaultListModel();
        m1.ensureCapacity(99);
        harness.check(m1.capacity() >= 99);
    }
}

