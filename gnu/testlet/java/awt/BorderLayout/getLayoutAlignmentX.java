/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.BorderLayout;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.BorderLayout;
import javax.swing.JComponent;

public class getLayoutAlignmentX
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComponent rp = new JComponent(){};
        BorderLayout lm2 = new BorderLayout();
        harness.check(lm2.getLayoutAlignmentX(rp), 0.5);
        rp.setAlignmentX(0.2f);
        harness.check(lm2.getLayoutAlignmentX(rp), 0.5);
    }
}

