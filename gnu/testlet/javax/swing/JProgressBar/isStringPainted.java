/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JProgressBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JProgressBar;

public class isStringPainted
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JProgressBar pb = new JProgressBar();
        harness.check(pb.isStringPainted(), false);
        pb.setStringPainted(true);
        harness.check(pb.isStringPainted(), true);
    }
}

