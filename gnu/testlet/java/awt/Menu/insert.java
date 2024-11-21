/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.java.awt.Menu;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class insert
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.test1(harness);
        this.test2(harness);
        this.testPR28699(harness);
    }

    public void test1(TestHarness harness) {
        MenuItem itemD;
        harness.checkPoint("(MenuItem, int)");
        Menu menu = new Menu("Menu 1");
        MenuItem itemA = new MenuItem("Menu Item A");
        menu.insert(itemA, 0);
        harness.check(menu.getItem(0), itemA);
        MenuItem itemB = new MenuItem("Menu Item B");
        menu.insert(itemB, 1);
        harness.check(menu.getItem(1), itemB);
        MenuItem itemC = new MenuItem("Menu Item C");
        menu.insert(itemC, 0);
        harness.check(menu.getItem(0), itemC);
        harness.check(menu.getItem(1), itemA);
        harness.check(menu.getItem(2), itemB);
        boolean pass = false;
        try {
            itemD = new MenuItem("Menu Item D");
            menu.insert(itemD, -1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        itemD = new MenuItem("Menu Item D");
        menu.insert(itemD, 4);
        harness.check(menu.getItem(0), itemC);
        harness.check(menu.getItem(1), itemA);
        harness.check(menu.getItem(2), itemB);
        harness.check(menu.getItem(3), itemD);
        pass = false;
        try {
            menu.insert((MenuItem)null, 0);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void test2(TestHarness harness) {
        harness.checkPoint("(String, int)");
        Menu menu = new Menu("Menu 1");
        menu.insert("Menu Item A", 0);
        harness.check(menu.getItem(0).getLabel(), (Object)"Menu Item A");
        menu.insert("Menu Item B", 1);
        harness.check(menu.getItem(1).getLabel(), (Object)"Menu Item B");
        menu.insert("Menu Item C", 0);
        harness.check(menu.getItem(0).getLabel(), (Object)"Menu Item C");
        harness.check(menu.getItem(1).getLabel(), (Object)"Menu Item A");
        harness.check(menu.getItem(2).getLabel(), (Object)"Menu Item B");
        boolean pass = false;
        try {
            menu.insert("Menu Item D", -1);
        }
        catch (IllegalArgumentException e) {
            pass = true;
        }
        harness.check(pass);
        menu.insert("Menu Item D", 4);
        harness.check(menu.getItem(0).getLabel(), (Object)"Menu Item C");
        harness.check(menu.getItem(1).getLabel(), (Object)"Menu Item A");
        harness.check(menu.getItem(2).getLabel(), (Object)"Menu Item B");
        harness.check(menu.getItem(3).getLabel(), (Object)"Menu Item D");
        menu.insert((String)null, 0);
        harness.check(menu.getItem(0).getLabel(), null);
    }

    public void testPR28699(TestHarness harness) {
        harness.checkPoint("PR29699");
        Frame f = new Frame("AWT Menu Test");
        MenuBar mb = new MenuBar();
        Menu m = new Menu("Menu 1");
        mb.add(m);
        f.setMenuBar(mb);
        f.add(new Button("Button"));
        f.pack();
        MenuItem itemA = new MenuItem("Item A");
        m.insert(itemA, 0);
        MenuItem itemB = new MenuItem("Item B");
        m.insert(itemB, 0);
        MenuItem itemC = new MenuItem("Item C");
        m.insert(itemC, 1);
        MenuItem itemD = new MenuItem("Item D");
        m.insert(itemD, 1);
        harness.check(m.getItem(0), itemB);
        harness.check(m.getItem(1), itemD);
        harness.check(m.getItem(2), itemC);
        harness.check(m.getItem(3), itemA);
        f.dispose();
    }
}

