/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComponent.TestLayout;
import javax.swing.JComponent;

public class getAlignmentY
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComponent c = new JComponent(){};
        TestLayout l = new TestLayout();
        c.setLayout(l);
        l.alignmentY = 0.3f;
        harness.check(c.getAlignmentY(), 0.3f);
        c.setAlignmentY(0.2f);
        harness.check(c.getAlignmentY(), 0.2f);
        c.setAlignmentY(100.0f);
        harness.check(c.getAlignmentY(), 1.0);
        c.setAlignmentY(-100.0f);
        harness.check(c.getAlignmentY(), 0.0);
    }
}

