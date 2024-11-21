/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Container;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.java.awt.Container.TestLayout;
import java.awt.Container;

public class getAlignmentX
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testWithLayout(harness);
    }

    private void testWithLayout(TestHarness harness) {
        Container c = new Container();
        TestLayout l = new TestLayout();
        c.setLayout(l);
        l.alignmentX = 0.3f;
        harness.check(c.getAlignmentX(), 0.3f);
        l.alignmentX = 0.6f;
        harness.check(c.getAlignmentX(), 0.6f);
    }
}

