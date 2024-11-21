/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;

public class isEmpty
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("isEmpty()");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        harness.check(m1.isEmpty());
        m1.addElement("A");
        harness.check(!m1.isEmpty());
        m1.clear();
        harness.check(m1.isEmpty());
    }
}

