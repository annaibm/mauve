/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;

public class toArray
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("toArray()");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        m1.addElement("A");
        m1.addElement("B");
        Object[] a1 = m1.toArray();
        harness.check(a1.length, 2);
        harness.check(a1[0], (Object)"A");
        harness.check(a1[1], (Object)"B");
        m1.clear();
        a1 = m1.toArray();
        harness.check(a1.length, 0);
    }
}

