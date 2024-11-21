/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenuBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.SingleSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalMenuBarUI;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("JMenuBar(constructor)");
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JMenuBar mb = new JMenuBar();
        harness.check(mb.getComponentCount(), 0);
        harness.check(mb.getMenuCount(), 0);
        harness.check(mb.getMargin(), new Insets(0, 0, 0, 0));
        try {
            mb.getMenu(0);
            harness.check(false);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            harness.check(true);
        }
        harness.check(mb.getSelectionModel() instanceof SingleSelectionModel);
        harness.check(mb.getSubElements().length, 0);
        harness.check(mb.getUI() instanceof MetalMenuBarUI);
        harness.check(mb.isBorderPainted());
        harness.check(!mb.isSelected());
    }
}

