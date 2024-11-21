/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalScrollButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import javax.swing.plaf.metal.MetalScrollButton;

public class getMinimumSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MetalScrollButton b = new MetalScrollButton(1, 27, true);
        harness.check(b.getMinimumSize(), new Dimension(27, 25));
        b = new MetalScrollButton(1, 27, false);
        harness.check(b.getMinimumSize(), new Dimension(27, 25));
        b = new MetalScrollButton(1, 15, true);
        harness.check(b.getMinimumSize(), new Dimension(15, 13));
        b = new MetalScrollButton(1, 15, false);
        harness.check(b.getMinimumSize(), new Dimension(15, 13));
        b = new MetalScrollButton(3, 27, true);
        harness.check(b.getMinimumSize(), new Dimension(26, 27));
        b = new MetalScrollButton(3, 27, false);
        harness.check(b.getMinimumSize(), new Dimension(25, 27));
        b = new MetalScrollButton(3, 15, true);
        harness.check(b.getMinimumSize(), new Dimension(14, 15));
        b = new MetalScrollButton(3, 15, false);
        harness.check(b.getMinimumSize(), new Dimension(13, 15));
        b = new MetalScrollButton(5, 27, true);
        harness.check(b.getMinimumSize(), new Dimension(27, 26));
        b = new MetalScrollButton(5, 27, false);
        harness.check(b.getMinimumSize(), new Dimension(27, 25));
        b = new MetalScrollButton(5, 15, true);
        harness.check(b.getMinimumSize(), new Dimension(15, 14));
        b = new MetalScrollButton(5, 15, false);
        harness.check(b.getMinimumSize(), new Dimension(15, 13));
        b = new MetalScrollButton(7, 27, true);
        harness.check(b.getMinimumSize(), new Dimension(25, 27));
        b = new MetalScrollButton(7, 27, false);
        harness.check(b.getMinimumSize(), new Dimension(25, 27));
        b = new MetalScrollButton(7, 15, true);
        harness.check(b.getMinimumSize(), new Dimension(13, 15));
        b = new MetalScrollButton(7, 15, false);
        harness.check(b.getMinimumSize(), new Dimension(13, 15));
    }
}

