/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.MenuItem;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.MenuItem;

public class label1
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MenuItem m1 = new MenuItem();
        harness.check(m1.getLabel() == "");
        MenuItem m2 = new MenuItem("menu item 2");
        harness.check(m2.getLabel() == "menu item 2");
        MenuItem m3 = new MenuItem(null);
        harness.check(m3.getLabel() == null);
    }
}

