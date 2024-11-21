/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComboBox.TestModel1;
import javax.swing.JComboBox;

public class SimpleSelectionTest
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComboBox combo = new JComboBox(new TestModel1());
        harness.check(combo.getItemCount(), 4, "get item count");
        harness.check(combo.getSelectedItem(), "In", "preselected item");
        combo.setSelectedItem("Freedom");
        harness.check(combo.getSelectedIndex(), 3, "select by value");
        combo.setSelectedItem("BOGUS");
        harness.check(combo.getSelectedIndex(), 3, "select by unknown value");
        harness.check(combo.getItemAt(1), "As", "return via index");
        combo.setSelectedIndex(-1);
        harness.check(combo.getSelectedItem(), null, "unselect via index");
        try {
            combo.setSelectedIndex(-12);
            harness.fail("illegal index access 1: exception not thrown");
        }
        catch (Exception e) {
            harness.check(e instanceof IllegalArgumentException, "illegal index access 1");
        }
        try {
            combo.setSelectedIndex(1200);
            harness.fail("illegal index access 2: exception not thrown");
        }
        catch (Exception e) {
            harness.check(e instanceof IllegalArgumentException, "illegal index access 2");
        }
        combo.setSelectedIndex(0);
        harness.check(combo.getSelectedItem(), "Free", "valid selection via index");
        combo.setSelectedItem(null);
        harness.check(combo.getSelectedItem(), null, "unselect via null");
    }
}

