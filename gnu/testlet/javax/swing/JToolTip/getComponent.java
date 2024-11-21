/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JToolTip;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JButton;
import javax.swing.JToolTip;

public class getComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JButton component2 = new JButton("Button");
        JToolTip tt = new JToolTip();
        harness.check(tt.getComponent(), null);
        tt.setComponent(component2);
        harness.check(tt.getComponent(), component2);
    }
}

