/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComponent.TestLayout;
import javax.swing.JComponent;

public class getAlignmentX
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComponent c = new JComponent(){};
        TestLayout l = new TestLayout();
        c.setLayout(l);
        l.alignmentX = 0.3f;
        harness.check(c.getAlignmentX(), 0.3f);
        c.setAlignmentX(0.2f);
        harness.check(c.getAlignmentX(), 0.2f);
        c.setAlignmentX(100.0f);
        harness.check(c.getAlignmentX(), 1.0);
        c.setAlignmentX(-100.0f);
        harness.check(c.getAlignmentX(), 0.0);
    }
}

