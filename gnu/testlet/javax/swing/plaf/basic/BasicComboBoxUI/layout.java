/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI.MyBasicComboBoxUILAF;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class layout
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MyBasicComboBoxUILAF());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        JComboBox cb = new JComboBox();
        cb.setEditable(true);
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(cb);
        frame.setContentPane(panel);
        frame.pack();
        JTextField tf = (JTextField)cb.getEditor().getEditorComponent();
        Font font = cb.getFont();
        FontMetrics fm = cb.getFontMetrics(font);
        int height = cb.getHeight();
        int width = fm.stringWidth("m") * tf.getColumns() + 1;
        harness.check(tf.getBounds(), new Rectangle(0, 0, width, height));
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

