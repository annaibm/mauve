/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalIconFactory.PaletteCloseIcon;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.metal.MetalIconFactory;

public class getIconHeight
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MetalIconFactory.PaletteCloseIcon icon = new MetalIconFactory.PaletteCloseIcon();
        harness.check(icon.getIconHeight(), 7);
    }
}

