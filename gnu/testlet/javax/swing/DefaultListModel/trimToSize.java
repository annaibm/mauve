/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;

public class trimToSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("trimToSize()");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        m1.addElement("A");
        m1.addElement("B");
        m1.trimToSize();
        harness.check(m1.capacity(), 2);
        DefaultListModel m2 = new DefaultListModel();
        m2.trimToSize();
        harness.check(m2.capacity(), 0);
    }
}

