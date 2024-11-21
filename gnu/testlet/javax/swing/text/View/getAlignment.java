/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.View;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.View.TestView;

public class getAlignment
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestView v = new TestView();
        harness.check(v.getAlignment(0), 0.5);
        harness.check(v.getAlignment(1), 0.5);
        harness.check(v.getAlignment(-1), 0.5);
        harness.check(v.getAlignment(123), 0.5);
    }
}

