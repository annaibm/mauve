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

public class setComboBox
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComboBox<Object> jcb1 = new JComboBox<Object>(new Object[]{"A", "B", "C"});
        JComboBox<Object> jcb2 = new JComboBox<Object>(new Object[]{"X", "Y", "Z"});
        MetalComboBoxIcon icon = new MetalComboBoxIcon();
        MetalComboBoxButton b = new MetalComboBoxButton(jcb1, icon, new CellRendererPane(), new JList<Object>());
        harness.check(b.getComboBox() == jcb1);
        b.setComboBox(jcb2);
        harness.check(b.getComboBox() == jcb2);
        b.setComboBox(null);
        harness.check(b.getComboBox() == null);
    }
}

