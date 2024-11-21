/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;

public class elementAt
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("elementAt(int)");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        m1.addElement("A");
        m1.addElement(null);
        m1.addElement("C");
        harness.check(m1.elementAt(0), (Object)"A");
        harness.check(m1.elementAt(1), null);
        harness.check(m1.elementAt(2), (Object)"C");
        boolean pass = false;
        try {
            m1.elementAt(-1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.elementAt(999);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

