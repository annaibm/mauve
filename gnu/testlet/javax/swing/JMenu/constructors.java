/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenu;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultButtonModel;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import javax.swing.MenuElement;

public class constructors
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
        this.testConstructor5(harness);
        this.testConstructor6(harness);
        this.testConstructor7(harness);
    }

    public void testConstructor1(TestHarness harness) {
        JMenu m = new JMenu();
        harness.check(m.isOpaque(), false);
        harness.check(m.getText(), (Object)"");
        harness.check(m.getIcon(), null);
    }

    public void testConstructor2(TestHarness harness) {
        JMenu m = new JMenu("Menu Text");
        harness.check(m.getText(), (Object)"Menu Text");
        harness.check(m.getIcon(), null);
        harness.check(m.getPopupMenu().getInvoker() instanceof JMenu);
        harness.check(m.isOpaque(), false);
    }

    public void testConstructor3(TestHarness harness) {
        String title = null;
        JMenu m = new JMenu(title);
        harness.check(m.getText(), (Object)"");
    }

    public void testConstructor4(TestHarness harness) {
        AbstractAction myAction = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("MyAction");
            }
        };
        JMenu m = new JMenu(myAction);
        harness.check(m.getText(), null);
        harness.check(m.getIcon(), null);
        harness.check(m.getAction(), myAction);
        harness.check(m.getName(), null);
        harness.check(m.getAccelerator(), null);
        harness.check(m.getMnemonic(), 0);
        harness.check(m.getActionCommand(), null);
        harness.check(m.getPopupMenu().getInvoker() instanceof JMenu);
        harness.check(m.isOpaque(), false);
    }

    public void testConstructor5(TestHarness harness) {
        Action myAction = null;
        JMenu m = new JMenu(myAction);
        harness.check(m.getAction(), null);
    }

    public void testConstructor6(TestHarness harness) {
        JMenu m = new JMenu("Menu Text", true);
        harness.check(m.getText(), (Object)"Menu Text");
        harness.check(m.getIcon(), null);
        boolean pass = false;
        try {
            m.isTearOff();
        }
        catch (Error e) {
            pass = true;
        }
        harness.check(pass);
    }

    public void testConstructor7(TestHarness harness) {
        JMenu m = new JMenu();
        harness.check(m.getVerticalAlignment(), 0);
        harness.check(m.getVerticalTextPosition(), 0);
        harness.check(m.isBorderPainted(), true);
        harness.check(m.isContentAreaFilled(), true);
        harness.check(m.isFocusPainted(), false);
        harness.check(m.isFocusable(), true);
        harness.check(m.getAlignmentX(), 0.5);
        harness.check(m.getAlignmentY(), 0.5);
        harness.check(m.getDisplayedMnemonicIndex(), -1);
        harness.check(m.isFocusPainted(), false);
        harness.check(m.getHorizontalAlignment(), 10);
        harness.check(m.getHorizontalTextPosition(), 11);
        harness.check(m.getModel() instanceof DefaultButtonModel);
        harness.check(m.getModel() != null);
        harness.check(m.getUIClassID(), (Object)"MenuUI");
        harness.check(m.getComponent() instanceof Component);
        harness.check(m.getComponent() != null);
        harness.check(m.getDelay(), 200);
        harness.check(m.getItem(0), null);
        harness.check(m.getItemCount(), 0);
        harness.check(m.getLayout(), null);
        harness.check(m.getMenuComponent(0), null);
        harness.check(m.getMenuComponentCount(), 0);
        harness.check(m.getPopupMenu() instanceof JPopupMenu);
        harness.check(m.getPopupMenu() != null);
        harness.check(m.isPopupMenuVisible(), false);
        harness.check(m.isSelected(), false);
        harness.check(m.getSubElements() instanceof MenuElement[]);
        harness.check(m.getSubElements() != null);
        harness.check(m.isTopLevelMenu(), false);
    }
}

