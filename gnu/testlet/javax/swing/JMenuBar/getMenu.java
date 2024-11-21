/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenuBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class getMenu
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JMenuBar mb = new JMenuBar();
        try {
            mb.add((JMenu)null);
            harness.check(false);
        }
        catch (NullPointerException e) {
            harness.check(true);
        }
        JMenu menu1 = new JMenu("menu1");
        mb.add(menu1);
        harness.check(mb.getMenuCount(), 1);
        harness.check(mb.getMenu(0), menu1);
        JMenu menu2 = new JMenu("menu2");
        mb.add(menu2);
        harness.check(mb.getMenuCount(), 2);
        harness.check(mb.getMenu(0), menu1);
        harness.check(mb.getMenu(1), menu2);
        JLabel label = new JLabel("label");
        mb.add(label);
        harness.check(mb.getMenuCount(), 3);
        harness.check(mb.getMenu(2), null);
        JMenu menu3 = new JMenu("menu3");
        mb.add(menu3);
        harness.check(mb.getMenuCount(), 4);
        harness.check(mb.getMenu(0), menu1);
        harness.check(mb.getMenu(1), menu2);
        harness.check(mb.getMenu(2), null);
        harness.check(mb.getMenu(3), menu3);
    }
}

