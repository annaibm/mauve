/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.UIDefaults;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.UIDefaults;

public class getBoolean
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        UIDefaults defaults = new UIDefaults();
        defaults.put("B1", Boolean.FALSE);
        defaults.put("B2", Boolean.TRUE);
        defaults.put("B3", "X");
        harness.check(defaults.getBoolean("B1"), false);
        harness.check(defaults.getBoolean("B2"), true);
        harness.check(defaults.getBoolean("B3"), false);
        harness.check(defaults.getBoolean("B4"), false);
    }
}

