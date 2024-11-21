/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalComboBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalComboBoxUI.MyMetalComboBoxUI;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.MetalComboBoxButton;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class createArrowButton
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        JComboBox cb = new JComboBox();
        MyMetalComboBoxUI ui = new MyMetalComboBoxUI();
        cb.setUI(ui);
        JButton b = ui.createArrowButton();
        harness.check(b instanceof MetalComboBoxButton);
        Insets insets = b.getInsets();
        harness.check(insets, new Insets(3, 4, 4, 6));
        Insets margin = b.getMargin();
        harness.check(margin, new Insets(0, 1, 1, 3));
        harness.check(!(margin instanceof UIResource));
    }
}

