/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalComboBoxEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.plaf.metal.MetalComboBoxEditor.MyMetalComboBoxEditor;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class editorBorderInsets
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
        harness.check(MyMetalComboBoxEditor.getEditorBorderInsetsField(), new Insets(2, 2, 2, 0));
    }
}

