/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.MenuBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Menu;
import java.awt.MenuBar;

public class addMenu
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MenuBar mb = new MenuBar();
        harness.check(mb.countMenus(), 0);
        Menu m = new Menu("Testing");
        mb.add(m);
        harness.check(mb.countMenus(), 1);
        harness.check(mb.getMenu(0), m);
        harness.check(m.getParent(), mb);
        mb.remove(m);
        harness.check(mb.countMenus(), 0);
        harness.check(m.getParent(), null);
        mb.add(m);
        harness.check(mb.countMenus(), 1);
        harness.check(mb.getMenu(0), m);
        harness.check(m.getParent(), mb);
        Menu m2 = new Menu("SecondMenu");
        mb.add(m2);
        harness.check(mb.countMenus(), 2);
        harness.check(mb.getMenu(0), m);
        harness.check(mb.getMenu(1), m2);
        harness.check(m2.getParent(), mb);
        mb.remove(0);
        harness.check(mb.countMenus(), 1);
        harness.check(mb.getMenu(0), m2);
        harness.check(m.getParent(), null);
        harness.check(m2.getParent(), mb);
        mb.remove(m2);
        harness.check(mb.countMenus(), 0);
        harness.check(m2.getParent(), null);
    }
}

