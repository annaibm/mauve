/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JProgressBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JProgressBar;

public class getPercentComplete
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JProgressBar pb = new JProgressBar(0, 9);
        harness.check(pb.getPercentComplete(), 0.0);
        pb.setValue(3);
        harness.check(pb.getPercentComplete(), 0.3333333333333333);
        pb = new JProgressBar(5, 10);
        harness.check(pb.getPercentComplete(), 0.0);
        pb.setValue(6);
        harness.check(pb.getPercentComplete(), 0.2);
        pb = new JProgressBar(10, 10);
        harness.check(Double.isNaN(pb.getPercentComplete()));
    }
}

