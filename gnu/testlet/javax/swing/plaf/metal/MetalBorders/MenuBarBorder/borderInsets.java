/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalBorders.MenuBarBorder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalBorders.MenuBarBorder.MyMenuBarBorder;
import java.awt.Insets;

public class borderInsets
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.check(MyMenuBarBorder.getBorderInsets(), new Insets(1, 0, 1, 0));
    }
}

