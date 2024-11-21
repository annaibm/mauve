/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;

public class lastIndexOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("lastIndexOf(Object)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        m1.addElement("A");
        m1.addElement("B");
        m1.addElement("C");
        m1.addElement(null);
        m1.addElement("C");
        m1.addElement("B");
        m1.addElement("A");
        harness.check(m1.lastIndexOf("A"), 6);
        harness.check(m1.lastIndexOf("B"), 5);
        harness.check(m1.lastIndexOf("C"), 4);
        harness.check(m1.lastIndexOf(null), 3);
        harness.check(m1.lastIndexOf("Z"), -1);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("lastIndexOf(Object, int)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        m1.addElement("A");
        m1.addElement("B");
        m1.addElement("C");
        m1.addElement(null);
        m1.addElement("C");
        m1.addElement("B");
        m1.addElement("A");
        harness.check(m1.lastIndexOf("A", 6), 6);
        harness.check(m1.lastIndexOf("A", 5), 0);
        harness.check(m1.lastIndexOf("B", 6), 5);
        harness.check(m1.lastIndexOf("B", 5), 5);
        harness.check(m1.lastIndexOf("B", 4), 1);
        harness.check(m1.lastIndexOf(null, 4), 3);
        harness.check(m1.lastIndexOf(null, 3), 3);
        harness.check(m1.lastIndexOf(null, 2), -1);
        harness.check(m1.lastIndexOf("Z", 0), -1);
        harness.check(m1.lastIndexOf("Z", -1), -1);
        boolean pass = false;
        try {
            int n = m1.lastIndexOf("Z", 99);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

