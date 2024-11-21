/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.AlphaComposite;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.AlphaComposite;

public class equals
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        AlphaComposite a2;
        AlphaComposite a1 = AlphaComposite.getInstance(3, 0.3f);
        harness.check(!a1.equals(a2 = AlphaComposite.getInstance(3, 0.4f)));
        harness.check(!a1.equals(null));
        a2 = AlphaComposite.getInstance(3, 0.3f);
        harness.check(a1.equals(a2));
    }
}

