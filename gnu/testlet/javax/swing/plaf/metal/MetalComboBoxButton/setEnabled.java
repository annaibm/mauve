/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.metal.MetalComboBoxButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.CellRendererPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.plaf.metal.MetalComboBoxButton;
import javax.swing.plaf.metal.MetalComboBoxIcon;

public class setEnabled
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComboBox<Object> jcb = new JComboBox<Object>(new Object[]{"A", "B", "C"});
        MetalComboBoxIcon icon1 = new MetalComboBoxIcon();
        MetalComboBoxButton b = new MetalComboBoxButton(jcb, icon1, new CellRendererPane(), new JList<Object>());
        harness.check(b.isEnabled());
        b.setEnabled(false);
        harness.check(!b.isEnabled());
    }
}

