/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComboBox;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JComboBox;

public class getPrototypeDisplayValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JComboBox<Object> c = new JComboBox<Object>(new Object[]{"A", "B", "C"});
        harness.check(c.getPrototypeDisplayValue(), null);
        c.setPrototypeDisplayValue("XYZ");
        harness.check(c.getPrototypeDisplayValue(), (Object)"XYZ");
        c.setPrototypeDisplayValue(null);
        harness.check(c.getPrototypeDisplayValue(), null);
    }
}

