/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalScrollButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import javax.swing.plaf.metal.MetalScrollButton;

public class getMaximumSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MetalScrollButton b = new MetalScrollButton(1, 27, true);
        harness.check(b.getMaximumSize(), new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
    }
}

