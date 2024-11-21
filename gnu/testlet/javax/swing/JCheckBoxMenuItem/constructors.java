/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JCheckBoxMenuItem;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;

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
        this.testConstructor8(harness);
        this.testConstructor9(harness);
        this.testConstructor10(harness);
        this.testConstructor11(harness);
        this.testConstructor12(harness);
        this.testConstructor13(harness);
        this.testDefaultProperties(harness);
    }

    public void testConstructor1(TestHarness harness) {
        JCheckBoxMenuItem m = new JCheckBoxMenuItem();
        harness.check(m.getText(), (Object)"");
        harness.check(m.getIcon(), null);
        harness.check(m.isFocusable(), false);
    }

    public void testConstructor2(TestHarness harness) {
        ImageIcon i = new ImageIcon();
        JCheckBoxMenuItem m = new JCheckBoxMenuItem(i);
        harness.check(m.getText(), (Object)"");
        harness.check(m.getIcon(), i);
        harness.check(m.isFocusable(), false);
    }

    public void testConstructor3(TestHarness harness) {
        Icon i = null;
        JCheckBoxMenuItem m = new JCheckBoxMenuItem(i);
        harness.check(m.getText(), (Object)"");
        harness.check(m.getIcon(), null);
    }

    public void testConstructor4(TestHarness harness) {
        JCheckBoxMenuItem m = new JCheckBoxMenuItem("Label");
        harness.check(m.getText(), (Object)"Label");
        harness.check(m.getIcon(), null);
        harness.check(m.isFocusable(), false);
    }

    public void testConstructor5(TestHarness harness) {
        String label = null;
        JCheckBoxMenuItem m = new JCheckBoxMenuItem(label);
        harness.check(m.getText(), (Object)"");
        harness.check(m.getIcon(), null);
    }

    public void testConstructor6(TestHarness harness) {
        AbstractAction myAction = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("MyAction");
            }
        };
        JCheckBoxMenuItem m = new JCheckBoxMenuItem(myAction);
        harness.check(m.getAction(), myAction);
        harness.check(m.isFocusable(), false);
    }

    public void testConstructor7(TestHarness harness) {
        Action myAction = null;
        JCheckBoxMenuItem m = new JCheckBoxMenuItem(myAction);
        harness.check(m.getAction(), null);
    }

    public void testConstructor8(TestHarness harness) {
        ImageIcon i = new ImageIcon();
        JCheckBoxMenuItem m = new JCheckBoxMenuItem("Label", i);
        harness.check(m.getText(), (Object)"Label");
        harness.check(m.getIcon(), i);
        harness.check(m.getState(), false);
        harness.check(m.isFocusable(), false);
    }

    public void testConstructor9(TestHarness harness) {
        JCheckBoxMenuItem m = new JCheckBoxMenuItem(null, null);
        harness.check(m.getText(), (Object)"");
        harness.check(m.getIcon(), null);
        harness.check(m.getState(), false);
    }

    public void testConstructor10(TestHarness harness) {
        JCheckBoxMenuItem m = new JCheckBoxMenuItem("Label", true);
        harness.check(m.getText(), (Object)"Label");
        harness.check(m.getIcon(), null);
        harness.check(m.getState(), true);
        harness.check(m.isFocusable(), false);
    }

    public void testConstructor11(TestHarness harness) {
        JCheckBoxMenuItem m = new JCheckBoxMenuItem(null, false);
        harness.check(m.getText(), (Object)"");
        harness.check(m.getIcon(), null);
        harness.check(m.getState(), false);
    }

    public void testConstructor12(TestHarness harness) {
        ImageIcon i = new ImageIcon();
        JCheckBoxMenuItem m = new JCheckBoxMenuItem("Label", i, true);
        harness.check(m.getText(), (Object)"Label");
        harness.check(m.getIcon(), i);
        harness.check(m.getState(), true);
        harness.check(m.isFocusable(), false);
    }

    public void testConstructor13(TestHarness harness) {
        JCheckBoxMenuItem m = new JCheckBoxMenuItem(null, null, false);
        harness.check(m.getText(), (Object)"");
        harness.check(m.getIcon(), null);
        harness.check(m.getState(), false);
    }

    public void testDefaultProperties(TestHarness harness) {
        JCheckBoxMenuItem m = new JCheckBoxMenuItem("Label", new ImageIcon(), true);
        harness.check(m.isFocusPainted(), false);
        harness.check(m.getHorizontalAlignment(), 10);
        harness.check(m.getHorizontalTextPosition(), 11);
        harness.check(m.getUIClassID(), (Object)"CheckBoxMenuItemUI");
        harness.check(m.getAccelerator(), null);
        harness.check(m.isArmed(), false);
        harness.check(m.isEnabled(), true);
        harness.check(m.isRequestFocusEnabled(), true);
        harness.check(m.getHorizontalAlignment(), 10);
        harness.check(m.getHorizontalTextPosition(), 11);
        harness.check(m.getVerticalAlignment(), 0);
        harness.check(m.getVerticalTextPosition(), 0);
        harness.check(m.isBorderPainted(), true);
        harness.check(m.isContentAreaFilled(), true);
        harness.check(m.isFocusPainted(), false);
        harness.check(m.isFocusable(), false);
        harness.check(m.getAlignmentX(), 0.5);
        harness.check(m.getAlignmentY(), 0.5);
        harness.check(m.getDisplayedMnemonicIndex(), -1);
        harness.check(m.isOpaque(), true);
        harness.check(m.getActionCommand(), (Object)"Label");
        harness.check(m.getMnemonic(), 0);
        harness.check(m.getMargin().top, 2);
        harness.check(m.getMargin().left, 2);
        harness.check(m.getMargin().bottom, 2);
        harness.check(m.getMargin().right, 2);
        harness.check(m.getPressedIcon(), null);
        harness.check(m.isRolloverEnabled(), false);
        harness.check(m.getRolloverIcon(), null);
        harness.check(m.getRolloverSelectedIcon(), null);
        harness.check(m.isSelected(), true);
        harness.check(m.getSelectedIcon(), null);
        harness.check(m.getModel() instanceof DefaultButtonModel);
        harness.check(m.getModel() != null);
        harness.check(m.isVisible(), true);
    }
}

