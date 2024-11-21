/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalIconFactory;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Icon;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalIconFactory;

public class getInternalFrameAltMaximizeIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Icon icon = MetalIconFactory.getInternalFrameAltMaximizeIcon(12);
        harness.check(icon.getIconWidth(), 12);
        harness.check(icon.getIconHeight(), 12);
        harness.check(icon instanceof UIResource);
        Icon icon2 = MetalIconFactory.getInternalFrameAltMaximizeIcon(12);
        harness.check(icon != icon2);
    }
}

