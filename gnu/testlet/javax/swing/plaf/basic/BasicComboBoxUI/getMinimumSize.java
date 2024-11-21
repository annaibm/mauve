/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI.MyBasicComboBoxUI;
import java.awt.Dimension;
import java.awt.FontMetrics;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class getMinimumSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComboBox<Object> cb = new JComboBox<Object>();
        MyBasicComboBoxUI ui = new MyBasicComboBoxUI();
        cb.setUI(ui);
        int additionalHeight = 2;
        int additionalWidth = 2;
        FontMetrics fm = cb.getFontMetrics(cb.getFont());
        int width = fm.charWidth(' ') + additionalWidth;
        int height = fm.getHeight() + additionalHeight;
        harness.check(ui.getMinimumSize(cb), new Dimension(width + height, height));
        cb.setModel(new DefaultComboBoxModel<Object>(new Object[]{"X"}));
        width = fm.charWidth('X') + additionalWidth;
        harness.check(ui.getMinimumSize(cb), new Dimension(width + height, height));
        cb.setPrototypeDisplayValue("XX");
        width = fm.stringWidth("XX") + additionalWidth;
        harness.check(ui.getMinimumSize(cb), new Dimension(width + height, height));
    }
}

