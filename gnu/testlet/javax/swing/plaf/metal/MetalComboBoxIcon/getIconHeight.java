/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalComboBoxIcon;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.plaf.metal.MetalComboBoxIcon;

public class getIconHeight
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MetalComboBoxIcon icon = new MetalComboBoxIcon();
        harness.check(icon.getIconHeight(), 5);
    }
}

