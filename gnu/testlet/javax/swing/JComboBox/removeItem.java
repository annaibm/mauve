/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JComboBox;
import javax.swing.UIManager;

public class removeItem
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
        c1.removeItem("Item 1");
        harness.check(c1.getSelectedIndex(), -1);
        harness.check(c1.getSelectedItem(), null);
        c1.addItem("Item 1");
        harness.check(c1.getSelectedItem(), (Object)"Item 1");
        c1.addItem("Item 2");
        harness.check(c1.getSelectedItem(), (Object)"Item 1");
        c1.addItem("Item 3");
        harness.check(c1.getSelectedItem(), (Object)"Item 1");
        c1.setSelectedItem("Item 3");
        harness.check(c1.getSelectedItem(), (Object)"Item 3");
        c1.removeItem("Item 3");
        harness.check(c1.getSelectedItem(), (Object)"Item 2");
        c1.removeItem(null);
        harness.check(c1.getSelectedItem(), (Object)"Item 2");
        c1.removeItem("Item 2");
        harness.check(c1.getSelectedItem(), (Object)"Item 1");
        harness.check(c1.getSelectedIndex(), 0);
        c1.addItem("Item A");
        c1.removeItem("Item 1");
        harness.check(c1.getSelectedItem(), (Object)"Item A");
        harness.check(c1.getSelectedIndex(), 0);
    }
}

