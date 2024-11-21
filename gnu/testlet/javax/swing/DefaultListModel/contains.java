/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;

public class contains
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("contains(Object)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        m1.addElement("A");
        m1.addElement("B");
        harness.check(m1.contains("A"));
        harness.check(m1.contains("B"));
        harness.check(!m1.contains("C"));
        harness.check(!m1.contains(null));
        m1.addElement(null);
        harness.check(m1.contains(null));
    }
}

