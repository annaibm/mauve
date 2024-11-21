/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ButtonGroup;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;

public class getButtonCount
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ButtonGroup g = new ButtonGroup();
        harness.check(g.getButtonCount(), 0);
        JToggleButton b1 = new JToggleButton("B1");
        g.add(b1);
        harness.check(g.getButtonCount(), 1);
        JToggleButton b2 = new JToggleButton("B2");
        g.add(b2);
        harness.check(g.getButtonCount(), 2);
        g.remove(b2);
        harness.check(g.getButtonCount(), 1);
        g.remove(b1);
        harness.check(g.getButtonCount(), 0);
    }
}

