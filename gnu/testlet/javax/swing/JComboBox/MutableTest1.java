/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JComboBox.TestModel1;
import javax.swing.JComboBox;

public class MutableTest1
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComboBox<String> combo = new JComboBox<String>(new TestModel1());
        boolean ok = false;
        try {
            combo.insertItemAt("BOGUS", 0);
        }
        catch (RuntimeException re) {
            ok = true;
        }
        harness.check(ok, "insertItemAt");
        ok = false;
        try {
            combo.removeItem("BOGUS");
        }
        catch (RuntimeException re) {
            ok = true;
        }
        harness.check(ok, "removeItem");
        ok = false;
        try {
            combo.removeItemAt(0);
        }
        catch (RuntimeException re) {
            ok = true;
        }
        harness.check(ok, "removeItemAt");
        ok = false;
        try {
            combo.removeAllItems();
        }
        catch (RuntimeException re) {
            ok = true;
        }
        harness.check(ok, "removeAllItems");
    }
}

