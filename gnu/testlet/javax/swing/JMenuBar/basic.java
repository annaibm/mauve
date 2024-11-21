/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenuBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Insets;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicMenuBarUI;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.MetalMenuBarUI;
import javax.swing.plaf.multi.MultiMenuBarUI;

public class basic
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.setMargin(harness);
        this.setUI(harness);
        this.setBorderPainted(harness);
        this.setSelected(harness);
    }

    public void setMargin(TestHarness harness) {
        JMenuBar mb = new JMenuBar();
        mb.setMargin(new Insets(5, 5, 5, 5));
        harness.check(mb.getMargin(), new Insets(5, 5, 5, 5));
        mb.setMargin(null);
        harness.check(mb.getMargin(), new Insets(0, 0, 0, 0));
    }

    public void setUI(TestHarness harness) {
        JMenuBar mb = new JMenuBar();
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        mb.setUI(new BasicMenuBarUI());
        harness.check(mb.getUI() instanceof BasicMenuBarUI);
        mb.setUI(new MultiMenuBarUI());
        harness.check(mb.getUI() instanceof MultiMenuBarUI);
        mb.updateUI();
        harness.check(mb.getUI() instanceof MetalMenuBarUI);
    }

    public void setBorderPainted(TestHarness harness) {
        JMenuBar mb = new JMenuBar();
        mb.setBorderPainted(false);
        harness.check(!mb.isBorderPainted());
        mb.setBorderPainted(true);
        harness.check(mb.isBorderPainted());
    }

    public void setSelected(TestHarness harness) {
        JMenuBar mb = new JMenuBar();
        harness.check(!mb.isSelected());
        JMenu menu = new JMenu("menu");
        mb.add(menu);
        mb.setSelected(menu);
        harness.check(mb.isSelected());
    }
}

