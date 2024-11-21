/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.AlphaComposite;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AlphaComposite;

public class getInstance14
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AlphaComposite a = AlphaComposite.getInstance(10);
        harness.check(a.getRule(), 10);
        harness.check(a.getAlpha(), 1.0);
        a = AlphaComposite.getInstance(11);
        harness.check(a.getRule(), 11);
        harness.check(a.getAlpha(), 1.0);
        a = AlphaComposite.getInstance(12);
        harness.check(a.getRule(), 12);
        harness.check(a.getAlpha(), 1.0);
    }
}

