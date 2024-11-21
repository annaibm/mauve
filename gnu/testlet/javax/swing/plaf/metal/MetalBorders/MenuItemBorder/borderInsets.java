/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalBorders.MenuItemBorder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalBorders.MenuItemBorder.MyMenuItemBorder;
import java.awt.Insets;

public class borderInsets
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(MyMenuItemBorder.getBorderInsets(), new Insets(2, 2, 2, 2));
    }
}

