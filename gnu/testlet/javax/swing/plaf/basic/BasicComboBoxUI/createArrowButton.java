/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI.MyBasicComboBoxUI;
import gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI.MyBasicComboBoxUILAF;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class createArrowButton
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MyBasicComboBoxUILAF());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        MyBasicComboBoxUI ui = new MyBasicComboBoxUI();
        JButton b = ui.createArrowButton();
        harness.check(b instanceof BasicArrowButton);
        Border border = b.getBorder();
        harness.check(border instanceof BorderUIResource.CompoundBorderUIResource);
        Insets insets = b.getInsets();
        harness.check(insets, new Insets(4, 17, 5, 17));
        Insets margin = b.getMargin();
        harness.check(margin, new Insets(2, 14, 2, 14));
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

