/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalScrollButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.metal.MetalScrollButton;

public class isFocusable
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MetalScrollButton b = new MetalScrollButton(0, 0, false);
        harness.check(b.isFocusable(), false);
    }
}

