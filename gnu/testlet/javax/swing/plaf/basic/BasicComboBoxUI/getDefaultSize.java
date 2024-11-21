/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI.MyBasicComboBoxUI;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.JComboBox;

public class getDefaultSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComboBox cb = new JComboBox();
        MyBasicComboBoxUI ui = new MyBasicComboBoxUI();
        cb.setUI(ui);
        int additionalHeight = 2;
        int additionalWidth = 2;
        FontMetrics fm = cb.getFontMetrics(cb.getFont());
        int width = fm.charWidth(' ') + additionalWidth;
        int height = fm.getHeight() + additionalHeight;
        harness.check(ui.getDefaultSize(), new Dimension(width, height));
        cb.setFont(new Font("Dialog", 0, 32));
        fm = cb.getFontMetrics(cb.getFont());
        width = fm.charWidth(' ') + additionalWidth;
        height = fm.getHeight() + additionalHeight;
        harness.check(ui.getDefaultSize(), new Dimension(width, height));
    }
}

