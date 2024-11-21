/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class getPreferredSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testNonEditable(harness);
        this.testEditable(harness);
    }

    private void testNonEditable(TestHarness harness) {
        JComboBox<Object> cb = new JComboBox<Object>();
        BasicComboBoxUI ui = new BasicComboBoxUI();
        cb.setUI(ui);
        int additionalHeight = 2;
        int additionalWidth = 2;
        FontMetrics fm = cb.getFontMetrics(cb.getFont());
        int width = fm.charWidth(' ') + additionalWidth;
        int height = fm.getHeight() + additionalHeight;
        harness.check(ui.getPreferredSize(cb), new Dimension(width + height, height));
        cb.setModel(new DefaultComboBoxModel<Object>(new Object[]{"X"}));
        width = fm.charWidth('X') + additionalWidth;
        harness.check(ui.getPreferredSize(cb), new Dimension(width + height, height));
        cb.setModel(new DefaultComboBoxModel<Object>(new Object[]{null}));
        harness.check(ui.getPreferredSize(cb).height, height);
        cb.setModel(new DefaultComboBoxModel<Object>(new Object[]{""}));
        harness.check(ui.getPreferredSize(cb).height, height);
        cb.setPrototypeDisplayValue("XX");
        width = fm.stringWidth("XX") + additionalWidth;
        harness.check(ui.getPreferredSize(cb), new Dimension(width + height, height));
    }

    private void testEditable(TestHarness harness) {
        harness.checkPoint("testEditable()");
        JComboBox<Object> cb = new JComboBox<Object>();
        BasicComboBoxUI ui = new BasicComboBoxUI();
        cb.setUI(ui);
        JTextField tf = (JTextField)cb.getEditor().getEditorComponent();
        cb.setEditable(true);
        Font font = cb.getFont();
        FontMetrics fm = cb.getFontMetrics(font);
        int height = fm.getHeight() + 2;
        int width = fm.stringWidth("m") * tf.getColumns() + height;
        harness.check(ui.getPreferredSize(cb), new Dimension(width, height));
        cb.setModel(new DefaultComboBoxModel<Object>(new Object[]{"X"}));
        harness.check(ui.getPreferredSize(cb), new Dimension(width, height));
        cb.setPrototypeDisplayValue("XX");
        harness.check(ui.getPreferredSize(cb), new Dimension(width, height));
    }
}

