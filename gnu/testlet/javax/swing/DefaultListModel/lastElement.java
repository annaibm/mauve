/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.NoSuchElementException;
import javax.swing.DefaultListModel;

public class lastElement
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("lastElement()");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        m1.addElement("A");
        m1.addElement("B");
        m1.addElement("C");
        harness.check(m1.lastElement(), (Object)"C");
        m1.addElement(null);
        harness.check(m1.lastElement(), null);
        m1.clear();
        boolean pass = false;
        try {
            m1.lastElement();
        }
        catch (NoSuchElementException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

