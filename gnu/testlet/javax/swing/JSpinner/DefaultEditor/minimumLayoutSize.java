/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JSpinner.DefaultEditor;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JSpinner;

public class minimumLayoutSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("(Container)");
        JSpinner s = new JSpinner();
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor)s.getEditor();
        Dimension tfSize = editor.getTextField().getMinimumSize();
        Insets insets = editor.getInsets();
        Dimension result = editor.minimumLayoutSize(editor);
        harness.check(result.width, tfSize.width + insets.left + insets.right);
        harness.check(result.height, tfSize.height + insets.top + insets.bottom);
    }
}

