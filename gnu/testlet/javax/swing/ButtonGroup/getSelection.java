/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.ButtonGroup;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;

public class getSelection
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        ButtonGroup g = new ButtonGroup();
        harness.check(g.getSelection(), null);
        JToggleButton b1 = new JToggleButton("B1");
        g.add(b1);
        harness.check(g.getSelection(), null);
        JToggleButton b2 = new JToggleButton("B2");
        b2.setSelected(true);
        g.add(b2);
        harness.check(g.getSelection(), b2.getModel());
    }
}

