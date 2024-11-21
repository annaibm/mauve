/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ButtonGroup;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.JToggleButton;

public class remove
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ButtonGroup g = new ButtonGroup();
        JToggleButton b1 = new JToggleButton("B1");
        g.add(b1);
        g.remove(b1);
        harness.check(g.getButtonCount(), 0);
        harness.check(g.getSelection(), null);
        harness.check(((DefaultButtonModel)b1.getModel()).getGroup(), null);
        g.add(b1);
        JToggleButton b2 = new JToggleButton("B2");
        b2.setSelected(true);
        g.add(b2);
        g.remove(b2);
        harness.check(g.getButtonCount(), 1);
        harness.check(g.getSelection(), null);
        harness.check(((DefaultButtonModel)b2.getModel()).getGroup(), null);
        g.remove(null);
        harness.check(g.getButtonCount(), 1);
        harness.check(g.getSelection(), null);
    }
}

