/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ButtonGroup;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;

public class getElements
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ButtonGroup g = new ButtonGroup();
        Enumeration<AbstractButton> e = g.getElements();
        harness.check(e.hasMoreElements(), false);
        JToggleButton b1 = new JToggleButton("B1");
        g.add(b1);
        e = g.getElements();
        harness.check(e.nextElement(), b1);
        harness.check(e.hasMoreElements(), false);
        JToggleButton b2 = new JToggleButton("B2");
        g.add(b2);
        e = g.getElements();
        harness.check(e.nextElement(), b1);
        harness.check(e.nextElement(), b2);
        harness.check(e.hasMoreElements(), false);
    }
}

