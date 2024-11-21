/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalIconFactory;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Icon;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalIconFactory;

public class getTreeControlIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Icon icon1 = MetalIconFactory.getTreeControlIcon(false);
        harness.check(icon1.getIconWidth(), 18);
        harness.check(icon1.getIconHeight(), 18);
        harness.check(!(icon1 instanceof UIResource));
        Icon icon2 = MetalIconFactory.getTreeControlIcon(true);
        harness.check(icon2.getIconWidth(), 18);
        harness.check(icon2.getIconHeight(), 18);
        harness.check(!(icon2 instanceof UIResource));
    }
}

