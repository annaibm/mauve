/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.DefaultListModel;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Enumeration;
import javax.swing.DefaultListModel;

public class elements
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("elements()");
        DefaultListModel<String> m1 = new DefaultListModel<String>();
        Enumeration e = m1.elements();
        harness.check(!e.hasMoreElements());
        m1.addElement("A");
        m1.addElement("B");
        m1.addElement("C");
        e = m1.elements();
        harness.check(e.nextElement(), (Object)"A");
        harness.check(e.nextElement(), (Object)"B");
        harness.check(e.nextElement(), (Object)"C");
        harness.check(!e.hasMoreElements());
    }
}

