/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;

public class indexOf
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("indexOf(Object)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        m1.addElement("A");
        m1.addElement("B");
        m1.addElement("C");
        m1.addElement(null);
        m1.addElement("C");
        m1.addElement("B");
        m1.addElement("A");
        harness.check(m1.indexOf("A"), 0);
        harness.check(m1.indexOf("B"), 1);
        harness.check(m1.indexOf("C"), 2);
        harness.check(m1.indexOf(null), 3);
        harness.check(m1.indexOf("Z"), -1);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("indexOf(Object, int)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        m1.addElement("A");
        m1.addElement("B");
        m1.addElement("C");
        m1.addElement(null);
        m1.addElement("C");
        m1.addElement("B");
        m1.addElement("A");
        harness.check(m1.indexOf("A", 0), 0);
        harness.check(m1.indexOf("A", 1), 6);
        harness.check(m1.indexOf("B", 0), 1);
        harness.check(m1.indexOf("B", 1), 1);
        harness.check(m1.indexOf("B", 2), 5);
        harness.check(m1.indexOf(null, 0), 3);
        harness.check(m1.indexOf(null, 3), 3);
        harness.check(m1.indexOf(null, 4), -1);
        harness.check(m1.indexOf("Z", 0), -1);
        harness.check(m1.indexOf("Z", 99), -1);
        boolean pass = false;
        try {
            int n = m1.indexOf("Z", -1);
        }
        catch (IndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

