/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.View;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.text.View.TestView;

public class getResizeWeight
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestView v = new TestView();
        harness.check(v.getResizeWeight(0), 0);
        harness.check(v.getResizeWeight(1), 0);
        harness.check(v.getResizeWeight(-1), 0);
        harness.check(v.getResizeWeight(123), 0);
    }
}

