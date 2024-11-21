/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Container;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.awt.Container.TestLayout;
import java.awt.Container;

public class getAlignmentY
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testWithLayout(harness);
    }

    private void testWithLayout(TestHarness harness) {
        Container c = new Container();
        TestLayout l = new TestLayout();
        c.setLayout(l);
        l.alignmentY = 0.3f;
        harness.check(c.getAlignmentY(), 0.3f);
        l.alignmentY = 0.6f;
        harness.check(c.getAlignmentY(), 0.6f);
    }
}

