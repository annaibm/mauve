/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.AWTKeyStroke;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AWTKeyStroke;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AWTKeyStroke ks1 = AWTKeyStroke.getAWTKeyStroke('A');
        AWTKeyStroke ks2 = AWTKeyStroke.getAWTKeyStroke('A');
        harness.check(ks1.equals(ks2));
        harness.check(!ks1.equals(null));
        harness.check(!ks1.equals(new Integer(42)));
        ks1 = AWTKeyStroke.getAWTKeyStroke('a');
        harness.check(!ks1.equals(ks2));
        ks2 = AWTKeyStroke.getAWTKeyStroke('a');
        harness.check(ks1.equals(ks2));
        ks1 = AWTKeyStroke.getAWTKeyStroke(new Character('a'), 64);
        harness.check(!ks1.equals(ks2));
        ks2 = AWTKeyStroke.getAWTKeyStroke(new Character('a'), 64);
        harness.check(ks1.equals(ks2));
        ks1 = AWTKeyStroke.getAWTKeyStroke(65, 64, false);
        harness.check(!ks1.equals(ks2));
        ks2 = AWTKeyStroke.getAWTKeyStroke(65, 64, false);
        harness.check(ks1.equals(ks2));
        ks1 = AWTKeyStroke.getAWTKeyStroke(65, 64, true);
        harness.check(!ks1.equals(ks2));
        ks2 = AWTKeyStroke.getAWTKeyStroke(65, 64, true);
        harness.check(ks1.equals(ks2));
    }
}

