/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalIconFactory;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Icon;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalIconFactory;

public class getInternalFrameDefaultMenuIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Icon icon = MetalIconFactory.getInternalFrameDefaultMenuIcon();
        harness.check(icon.getIconWidth(), 16);
        harness.check(icon.getIconHeight(), 16);
        harness.check(icon instanceof UIResource);
        Icon icon2 = MetalIconFactory.getInternalFrameDefaultMenuIcon();
        harness.check(icon == icon2);
    }
}

