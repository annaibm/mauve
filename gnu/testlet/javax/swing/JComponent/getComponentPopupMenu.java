/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JComponent;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class getComponentPopupMenu
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        JPanel p = new JPanel();
        JPopupMenu popup1 = new JPopupMenu();
        JPopupMenu popup2 = new JPopupMenu();
        JButton c = new JButton("ABC");
        p.add(c);
        harness.check(c.getComponentPopupMenu(), null);
        harness.check(c.getInheritsPopupMenu(), false);
        c.setComponentPopupMenu(popup1);
        harness.check(c.getComponentPopupMenu(), popup1);
        p.setComponentPopupMenu(popup2);
        harness.check(c.getComponentPopupMenu(), popup1);
        c.setComponentPopupMenu(null);
        harness.check(c.getComponentPopupMenu(), null);
        c.setInheritsPopupMenu(true);
        harness.check(c.getComponentPopupMenu(), popup2);
        p.setComponentPopupMenu(null);
        harness.check(c.getComponentPopupMenu(), null);
    }
}

