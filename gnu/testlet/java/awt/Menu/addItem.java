/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Menu;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Menu;
import java.awt.MenuItem;

public class addItem
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        Menu m = new Menu("Test");
        harness.check(m.countItems(), 0);
        MenuItem i = new MenuItem("Testing");
        m.add(i);
        harness.check(m.countItems(), 1);
        harness.check(m.getItem(0), i);
        harness.check(i.getParent(), m);
        m.remove(i);
        harness.check(m.countItems(), 0);
        harness.check(i.getParent(), null);
        m.add(i);
        harness.check(m.countItems(), 1);
        harness.check(m.getItem(0), i);
        harness.check(i.getParent(), m);
        MenuItem i2 = new MenuItem("Second");
        m.insert(i2, 0);
        harness.check(m.countItems(), 2);
        harness.check(m.getItem(0), i2);
        harness.check(m.getItem(1), i);
        harness.check(i.getParent(), m);
        harness.check(i2.getParent(), m);
        m.remove(0);
        harness.check(m.countItems(), 1);
        harness.check(m.getItem(0), i);
        harness.check(i.getParent(), m);
        harness.check(i2.getParent(), null);
        m.remove(i);
        harness.check(m.countItems(), 0);
        harness.check(i.getParent(), null);
        i = new Menu("TestingMenu");
        m.add(i);
        harness.check(m.countItems(), 1);
        harness.check(m.getItem(0), i);
        harness.check(i.getParent(), m);
        m.remove(i);
        harness.check(m.countItems(), 0);
        harness.check(i.getParent(), null);
        m.add(i);
        harness.check(m.countItems(), 1);
        harness.check(m.getItem(0), i);
        harness.check(i.getParent(), m);
        i2 = new Menu("SecondMenu");
        m.insert(i2, 0);
        harness.check(m.countItems(), 2);
        harness.check(m.getItem(0), i2);
        harness.check(m.getItem(1), i);
        harness.check(i.getParent(), m);
        harness.check(i2.getParent(), m);
        m.remove(0);
        harness.check(m.countItems(), 1);
        harness.check(m.getItem(0), i);
        harness.check(i.getParent(), m);
        harness.check(i2.getParent(), null);
        m.remove(i);
        harness.check(m.countItems(), 0);
        harness.check(i.getParent(), null);
    }
}

