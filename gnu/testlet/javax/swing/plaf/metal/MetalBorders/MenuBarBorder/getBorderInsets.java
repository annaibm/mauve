/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalBorders.MenuBarBorder;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalBorders;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getBorderInsets
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
    }

    public void test1(TestHarness harness) {
        harness.checkPoint("getBorderInsets(Component)");
        try {
            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        MetalBorders.MenuBarBorder b = new MetalBorders.MenuBarBorder();
        Insets insets = b.getBorderInsets(null);
        harness.check(insets, new Insets(1, 0, 1, 0));
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("getBorderInsets(Component, Insets)");
        try {
            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        MetalBorders.MenuBarBorder b = new MetalBorders.MenuBarBorder();
        Insets insets = b.getBorderInsets(null, new Insets(1, 2, 3, 4));
        harness.check(insets, new Insets(1, 0, 1, 0));
        boolean pass = false;
        try {
            b.getBorderInsets(null, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

