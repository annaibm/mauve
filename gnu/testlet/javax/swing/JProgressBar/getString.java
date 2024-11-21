/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JProgressBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JProgressBar;

public class getString
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JProgressBar pb = new JProgressBar();
        harness.check(pb.getString(), (Object)"0%");
        pb.setString("XYZ");
        harness.check(pb.getString(), (Object)"XYZ");
        pb.setString(null);
        pb.setValue(100);
        harness.check(pb.getString(), (Object)"100%");
    }
}

