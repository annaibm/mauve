/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;

public class size
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("size()");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        harness.check(m1.size(), 0);
        m1.addElement("A");
        harness.check(m1.size(), 1);
        m1.addElement("B");
        harness.check(m1.size(), 2);
        m1.clear();
        harness.check(m1.size(), 0);
    }
}

