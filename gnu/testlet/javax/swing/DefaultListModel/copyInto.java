/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;

public class copyInto
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("copyInto(Object[])");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        m1.addElement("A");
        m1.addElement(null);
        m1.addElement("C");
        Object[] dest = new Object[3];
        m1.copyInto(dest);
        harness.check(dest[0], (Object)"A");
        harness.check(dest[1], null);
        harness.check(dest[2], (Object)"C");
        boolean pass = false;
        dest = new Object[2];
        try {
            m1.copyInto(dest);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            m1.copyInto(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        dest = new Object[4];
        dest[3] = "X";
        m1.copyInto(dest);
        harness.check(dest[3], (Object)"X");
    }
}

