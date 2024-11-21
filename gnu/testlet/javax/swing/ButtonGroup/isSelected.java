/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ButtonGroup;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.JToggleButton;

public class isSelected
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ButtonGroup g = new ButtonGroup();
        harness.check(g.isSelected(new DefaultButtonModel()), false);
        JToggleButton b1 = new JToggleButton("B1");
        g.add(b1);
        harness.check(g.isSelected(b1.getModel()), false);
        b1.getModel().setSelected(true);
        harness.check(g.isSelected(b1.getModel()), true);
        JToggleButton b2 = new JToggleButton("B2");
        b2.setSelected(true);
        g.add(b2);
        harness.check(g.isSelected(b2.getModel()), false);
        b2.getModel().setSelected(true);
        harness.check(g.isSelected(b1.getModel()), false);
        harness.check(g.isSelected(b2.getModel()), true);
        harness.check(g.isSelected(null), false);
    }
}

