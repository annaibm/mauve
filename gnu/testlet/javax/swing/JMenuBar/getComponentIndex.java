/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenuBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class getComponentIndex
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JMenuBar mb = new JMenuBar();
        JMenu menu1 = new JMenu("menu1");
        mb.add(menu1);
        JMenu menu2 = new JMenu("menu2");
        mb.add(menu2);
        JLabel label = new JLabel("label");
        mb.add(label);
        JMenu menu3 = new JMenu("menu3");
        mb.add(menu3);
        harness.check(mb.getComponentIndex(menu1), 0);
        harness.check(mb.getComponentIndex(menu2), 1);
        harness.check(mb.getComponentIndex(label), 2);
        harness.check(mb.getComponentIndex(menu3), 3);
    }
}

