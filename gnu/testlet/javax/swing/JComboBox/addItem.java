/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JComboBox;
import javax.swing.UIManager;

public class addItem
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }
        catch (Exception e) {
            harness.fail("Problem setting MetalLookAndFeel");
        }
        JComboBox<String> c1 = new JComboBox<String>();
        harness.check(c1.getSelectedIndex(), -1);
        harness.check(c1.getSelectedItem(), null);
        c1.addItem("Item 1");
        harness.check(c1.getSelectedIndex(), 0);
        harness.check(c1.getSelectedItem(), (Object)"Item 1");
        c1.addItem("Item 2");
        harness.check(c1.getSelectedIndex(), 0);
        harness.check(c1.getSelectedItem(), (Object)"Item 1");
        c1.addItem(null);
        harness.check(c1.getSelectedIndex(), 0);
        harness.check(c1.getSelectedItem(), (Object)"Item 1");
    }
}

