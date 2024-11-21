/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalScrollButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.metal.MetalScrollButton;

public class getButtonWidth
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MetalScrollButton b = new MetalScrollButton(1, 27, true);
        harness.check(b.getButtonWidth(), 27);
        b = new MetalScrollButton(3, 21, false);
        harness.check(b.getButtonWidth(), 21);
    }
}

