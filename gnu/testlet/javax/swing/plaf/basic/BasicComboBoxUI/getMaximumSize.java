/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicComboBoxUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class getMaximumSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComboBox cb = new JComboBox();
        BasicComboBoxUI ui = new BasicComboBoxUI();
        cb.setUI(ui);
        harness.check(ui.getMaximumSize(cb), new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
    }
}

