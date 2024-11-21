/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalBorders;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Insets;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalBorders;

public class getButtonBorder
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Border b = MetalBorders.getButtonBorder();
        harness.check(b instanceof UIResource);
        Insets insets = b.getBorderInsets(null);
        harness.check(insets, new Insets(3, 3, 3, 3));
    }
}

