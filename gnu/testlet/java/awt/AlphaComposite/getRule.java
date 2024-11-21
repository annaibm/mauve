/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.AlphaComposite;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AlphaComposite;

public class getRule
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AlphaComposite a = AlphaComposite.getInstance(3);
        harness.check(a.getRule(), 3);
    }
}

