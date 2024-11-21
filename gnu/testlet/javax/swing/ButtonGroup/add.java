/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ButtonGroup;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.JToggleButton;

public class add
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ButtonGroup g = new ButtonGroup();
        JToggleButton b1 = new JToggleButton("B1");
        g.add(b1);
        harness.check(g.getButtonCount(), 1);
        harness.check(g.getSelection(), null);
        harness.check(((DefaultButtonModel)b1.getModel()).getGroup(), g);
        JToggleButton b2 = new JToggleButton("B2");
        b2.setSelected(true);
        g.add(b2);
        harness.check(g.getButtonCount(), 2);
        harness.check(g.getSelection(), b2.getModel());
        harness.check(((DefaultButtonModel)b2.getModel()).getGroup(), g);
        JToggleButton b3 = new JToggleButton("B2");
        b3.setSelected(true);
        g.add(b3);
        harness.check(g.getButtonCount(), 3);
        harness.check(g.getSelection(), b2.getModel());
        harness.check(b2.isSelected(), true);
        harness.check(b3.isSelected(), false);
        harness.check(((DefaultButtonModel)b3.getModel()).getGroup(), g);
        g.add(null);
        harness.check(g.getButtonCount(), 3);
        harness.check(g.getSelection(), b2.getModel());
    }
}

