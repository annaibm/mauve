/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalIconFactory.TreeLeafIcon;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.metal.MetalIconFactory;

public class getAdditionalHeight
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MetalIconFactory.TreeLeafIcon icon = new MetalIconFactory.TreeLeafIcon();
        harness.check(icon.getAdditionalHeight(), 4);
    }
}

