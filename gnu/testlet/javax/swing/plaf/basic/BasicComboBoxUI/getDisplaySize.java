/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.TestLookAndFeel;
import gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI.MyBasicComboBoxUI;
import java.awt.Dimension;
import java.awt.FontMetrics;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class getDisplaySize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testNotEditable(harness);
        this.testEditable(harness);
    }

    private void testNotEditable(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new TestLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JComboBox<String> cb = new JComboBox<String>();
        MyBasicComboBoxUI ui = new MyBasicComboBoxUI();
        cb.setUI(ui);
        int additionalHeight = 2;
        int additionalWidth = 2;
        FontMetrics fm = cb.getFontMetrics(cb.getFont());
        int width = fm.charWidth(' ') + additionalWidth;
        int height = fm.getHeight() + additionalHeight;
        harness.check(ui.getDisplaySize(), new Dimension(width, height));
        cb.addItem("ABC");
        width = fm.stringWidth("ABC") + additionalWidth;
        harness.check(ui.getDisplaySize(), new Dimension(width, height));
        cb.addItem("A longer item");
        width = fm.stringWidth("A longer item") + additionalWidth;
        harness.check(ui.getDisplaySize(), new Dimension(width, height));
        cb.setPrototypeDisplayValue("Prototype");
        width = fm.stringWidth("Prototype") + additionalWidth;
        harness.check(ui.getDisplaySize(), new Dimension(width, height));
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private void testEditable(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new TestLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JComboBox<String> cb = new JComboBox<String>();
        cb.setEditable(true);
        MyBasicComboBoxUI ui = new MyBasicComboBoxUI();
        cb.setUI(ui);
        JTextField tf = (JTextField)cb.getEditor().getEditorComponent();
        int columns = tf.getColumns();
        FontMetrics fm = cb.getFontMetrics(cb.getFont());
        int width = fm.charWidth('m') * columns;
        int height = fm.getHeight() + 2;
        harness.check(ui.getDisplaySize(), new Dimension(width + 1, height));
        cb.addItem("ABC");
        harness.check(ui.getDisplaySize(), new Dimension(width, height));
        cb.addItem("A longer item");
        harness.check(ui.getDisplaySize(), new Dimension(width, height));
        cb.setPrototypeDisplayValue("Prototype");
        harness.check(ui.getDisplaySize(), new Dimension(width, height));
        cb.setPrototypeDisplayValue("Long Prototype Display Value");
        width = fm.stringWidth("Long Prototype Display Value") + 2;
        harness.check(ui.getDisplaySize(), new Dimension(width, height));
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
}

