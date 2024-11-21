/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComboBox.TestModel2;
import javax.swing.JComboBox;

public class MutableTest2
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComboBox<String> combo = new JComboBox<String>(new TestModel2());
        combo.insertItemAt("TESTVALUE", 5);
        harness.check(combo.getItemAt(5), "TESTVALUE", "insertItemAt");
        combo.removeItem("TESTVALUE");
        harness.check(combo.getItemCount(), 10, "removeItem");
        combo.removeItemAt(0);
        harness.check(combo.getItemCount(), 9, "removeItemAt");
        combo.removeAllItems();
        harness.check(combo.getItemCount(), 0, "removeAllItems");
    }
}

