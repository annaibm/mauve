/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalComboBoxEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalComboBoxEditor;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class constructor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            MetalLookAndFeel.setCurrentTheme(new DefaultMetalTheme());
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        MetalComboBoxEditor editor = new MetalComboBoxEditor();
        JTextField tf = (JTextField)editor.getEditorComponent();
        harness.check(tf.getColumns(), 9);
        harness.check(tf.getInsets(), new Insets(2, 2, 2, 0));
        harness.check(tf.getMargin(), new Insets(0, 0, 0, 0));
        harness.check(!(tf.getInsets() instanceof UIResource));
    }
}

