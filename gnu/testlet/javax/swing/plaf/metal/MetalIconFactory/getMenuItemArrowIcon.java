/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalIconFactory;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.Icon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalIconFactory;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getMenuItemArrowIcon
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Icon icon = MetalIconFactory.getMenuItemArrowIcon();
        harness.check(icon.getIconWidth(), 4);
        harness.check(icon.getIconHeight(), 8);
        harness.check(icon instanceof UIResource);
        Icon icon2 = MetalIconFactory.getMenuItemArrowIcon();
        harness.check(icon == icon2);
        harness.check(icon != MetalIconFactory.getMenuArrowIcon());
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        harness.check(icon, UIManager.getIcon("MenuItem.arrowIcon"));
    }
}

