/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class model
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        }
        catch (UnsupportedLookAndFeelException e) {
            harness.debug(e);
        }
        DefaultComboBoxModel<Object> model2 = new DefaultComboBoxModel<Object>(new Object[]{"A", "B", "C"});
        JComboBox<Object> cb = new JComboBox<Object>(model2);
        harness.check(cb.getModel(), model2);
        harness.check(cb.getSelectedIndex(), 0);
        model2.setSelectedItem("B");
        harness.check(cb.getSelectedItem(), (Object)"B");
        cb.setSelectedItem("C");
        harness.check(model2.getSelectedItem(), (Object)"C");
    }
}

