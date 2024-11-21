/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalBorders.MenuItemBorder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.plaf.metal.MetalBorders;

public class getBorderInsets
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("getBorderInsets(Component)");
        MetalBorders.MenuItemBorder b = new MetalBorders.MenuItemBorder();
        Insets insets = b.getBorderInsets(null);
        harness.check(insets, new Insets(2, 2, 2, 2));
        Insets insets2 = b.getBorderInsets(null);
        harness.check(insets == insets2);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("getBorderInsets(Component, Insets)");
        MetalBorders.MenuItemBorder b = new MetalBorders.MenuItemBorder();
        Insets insets = b.getBorderInsets(null, new Insets(1, 2, 3, 4));
        harness.check(insets, new Insets(2, 2, 2, 2));
        boolean pass = false;
        try {
            b.getBorderInsets(new JButton("Test"), null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

