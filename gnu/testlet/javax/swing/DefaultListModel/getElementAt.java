/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;

public class getElementAt
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getElementAt(int)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        m1.addElement("A");
        m1.addElement("B");
        m1.addElement("C");
        harness.check(m1.getElementAt(0), (Object)"A");
        harness.check(m1.getElementAt(1), (Object)"B");
        harness.check(m1.getElementAt(2), (Object)"C");
        boolean pass = false;
        try {
            Object e = m1.getElementAt(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            Object e = m1.getElementAt(3);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

