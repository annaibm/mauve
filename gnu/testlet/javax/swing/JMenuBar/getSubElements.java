/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenuBar;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.MenuElement;

public class getSubElements
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JMenuBar mb = new JMenuBar();
        JMenu menu1 = new JMenu("menu1");
        mb.add(menu1);
        JMenu menu2 = new JMenu("menu2");
        mb.add(menu2);
        MenuElement[] elements2 = mb.getSubElements();
        harness.check(elements2.length, 2);
        harness.check(elements2[0], menu1);
        harness.check(elements2[1], menu2);
        JLabel label = new JLabel("label");
        mb.add(label);
        elements2 = mb.getSubElements();
        harness.check(elements2.length, 2);
        harness.check(elements2[0], menu1);
        harness.check(elements2[1], menu2);
        JMenu menu3 = new JMenu("menu3");
        mb.add(menu3);
        elements2 = mb.getSubElements();
        harness.check(elements2.length, 3);
        harness.check(elements2[0], menu1);
        harness.check(elements2[1], menu2);
        harness.check(elements2[2], menu3);
    }
}

