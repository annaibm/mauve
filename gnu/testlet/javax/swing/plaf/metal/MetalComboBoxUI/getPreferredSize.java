/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalComboBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalComboBoxUI.MyMetalComboBoxUI;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.plaf.metal.MetalComboBoxButton;

public class getPreferredSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testNonEditable(harness);
        this.testEditable(harness);
    }

    private void testNonEditable(TestHarness harness) {
        harness.checkPoint("testNonEditable()");
        JComboBox<Object> cb = new JComboBox<Object>();
        MyMetalComboBoxUI ui = new MyMetalComboBoxUI();
        cb.setUI(ui);
        Insets insets = ui.getArrowButton().getInsets();
        Insets comboInsets = cb.getInsets();
        MetalComboBoxButton b = (MetalComboBoxButton)ui.getArrowButton();
        Dimension displaySize = ui.getDisplaySize();
        int width = displaySize.width + insets.left + 2 * insets.right + comboInsets.left + comboInsets.right + b.getComboIcon().getIconWidth();
        int height = displaySize.height + comboInsets.top + comboInsets.bottom + insets.top + insets.bottom;
        harness.check(ui.getPreferredSize(cb), new Dimension(width, height));
        cb.setModel(new DefaultComboBoxModel<Object>(new Object[]{"X"}));
        displaySize = ui.getDisplaySize();
        width = displaySize.width + insets.left + 2 * insets.right + comboInsets.left + comboInsets.right + b.getComboIcon().getIconWidth();
        height = displaySize.height + comboInsets.top + comboInsets.bottom + insets.top + insets.bottom;
        harness.check(ui.getPreferredSize(cb), new Dimension(width, height));
        cb.setPrototypeDisplayValue("XX");
        displaySize = ui.getDisplaySize();
        width = displaySize.width + insets.left + 2 * insets.right + comboInsets.left + comboInsets.right + b.getComboIcon().getIconWidth();
        height = displaySize.height + comboInsets.top + comboInsets.bottom + insets.top + insets.bottom;
        harness.check(ui.getPreferredSize(cb), new Dimension(width, height));
    }

    private void testEditable(TestHarness harness) {
        harness.checkPoint("testEditable()");
        JComboBox<Object> cb = new JComboBox<Object>();
        MyMetalComboBoxUI ui = new MyMetalComboBoxUI();
        cb.setUI(ui);
        cb.setEditable(true);
        Dimension dSize = ui.getDisplaySize();
        Insets i = cb.getInsets();
        Insets arrowMargin = ui.getArrowButton().getMargin();
        int width = dSize.width + i.left + i.right + dSize.height + arrowMargin.left + arrowMargin.right;
        int height = dSize.height + i.top + i.bottom + arrowMargin.top + arrowMargin.bottom;
        harness.check(ui.getPreferredSize(cb), new Dimension(width, height));
        cb.setModel(new DefaultComboBoxModel<Object>(new Object[]{"X"}));
        harness.check(ui.getPreferredSize(cb), new Dimension(width, height));
        cb.setPrototypeDisplayValue("XX");
        harness.check(ui.getPreferredSize(cb), new Dimension(width, height));
        JComboBox<Object> cb2 = new JComboBox<Object>();
        MyMetalComboBoxUI ui2 = new MyMetalComboBoxUI();
        cb2.setUI(ui2);
        cb2.setEditable(true);
        cb2.setFont(new Font("Dialog", 0, 24));
        dSize = ui2.getDisplaySize();
        i = cb2.getInsets();
        arrowMargin = ui2.getArrowButton().getMargin();
        width = dSize.width + i.left + i.right + dSize.height + arrowMargin.left + arrowMargin.right;
        height = dSize.height + i.top + i.bottom + arrowMargin.top + arrowMargin.bottom;
        harness.check(ui2.getPreferredSize(cb2), new Dimension(width, height));
        cb2.setModel(new DefaultComboBoxModel<Object>(new Object[]{"X"}));
        harness.check(ui2.getPreferredSize(cb2), new Dimension(width, height));
        cb2.setPrototypeDisplayValue("XX");
        harness.check(ui2.getPreferredSize(cb2), new Dimension(width, height));
    }
}

