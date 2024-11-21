/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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
        this.testProperties(harness);
    }

    public void testConstructor1(TestHarness harness) {
        JButton b = new JButton();
        harness.check(b.getText(), (Object)"");
        harness.check(b.getIcon(), null);
        harness.check(b.isFocusable(), true);
    }

    public void testConstructor2(TestHarness harness) {
        AbstractAction myAction = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("MyAction");
            }
        };
        JButton b = new JButton(myAction);
        harness.check(b.getAction(), myAction);
        harness.check(b.isFocusable(), true);
    }

    public void testConstructor3(TestHarness harness) {
        Action myAction = null;
        JButton b = new JButton(myAction);
        harness.check(b.getAction(), null);
    }

    public void testConstructor4(TestHarness harness) {
        ImageIcon i = new ImageIcon();
        JButton b = new JButton(i);
        harness.check(b.getIcon(), i);
        harness.check(b.isFocusable(), true);
    }

    public void testConstructor5(TestHarness harness) {
        Icon i = null;
        JButton b = new JButton(i);
        harness.check(b.getIcon(), null);
    }

    public void testConstructor6(TestHarness harness) {
        JButton b = new JButton("Button Text");
        harness.check(b.getText(), (Object)"Button Text");
        harness.check(b.isFocusable(), true);
    }

    public void testConstructor7(TestHarness harness) {
        JButton b = new JButton("");
        harness.check(b.getText(), (Object)"");
    }

    public void testConstructor8(TestHarness harness) {
        String buttonText = null;
        JButton b = new JButton(buttonText);
        harness.check(b.getText(), (Object)"");
    }

    public void testConstructor9(TestHarness harness) {
        ImageIcon i = new ImageIcon();
        JButton b = new JButton("Button Text", i);
        harness.check(b.getText(), (Object)"Button Text");
        harness.check(b.getIcon(), i);
        harness.check(b.isFocusable(), true);
    }

    public void testConstructor10(TestHarness harness) {
        JButton b = new JButton("Button Text", null);
        harness.check(b.getText(), (Object)"Button Text");
        harness.check(b.getIcon(), null);
    }

    public void testConstructor11(TestHarness harness) {
        ImageIcon i = new ImageIcon();
        JButton b = new JButton(null, i);
        harness.check(b.getText(), (Object)"");
        harness.check(b.getIcon(), i);
    }

    public void testConstructor12(TestHarness harness) {
        JButton b = new JButton(null, null);
        harness.check(b.getText(), (Object)"");
        harness.check(b.getIcon(), null);
    }

    public void testProperties(TestHarness harness) {
        JButton b = new JButton();
        harness.check(b.getUIClassID(), (Object)"ButtonUI");
        harness.check(b.getModel() instanceof ButtonModel);
        harness.check(b.getModel() != null);
        harness.check(b.getActionCommand(), (Object)"");
        harness.check(b.isBorderPainted(), true);
        harness.check(b.isContentAreaFilled(), true);
        harness.check(b.getDisabledIcon(), null);
        harness.check(b.getDisabledSelectedIcon(), null);
        harness.check(b.isEnabled(), true);
        harness.check(b.isFocusPainted(), true);
        harness.check(b.getHorizontalAlignment(), 0);
        harness.check(b.getHorizontalTextPosition(), 11);
        harness.check(b.getIcon(), null);
        harness.check(b.getLabel(), (Object)"");
        harness.check(b.getMnemonic(), 0);
        harness.check(b.getMargin().top, 2);
        harness.check(b.getMargin().left, 14);
        harness.check(b.getMargin().bottom, 2);
        harness.check(b.getMargin().right, 14);
        harness.check(b.getPressedIcon(), null);
        harness.check(b.isRolloverEnabled(), true);
        harness.check(b.getRolloverIcon(), null);
        harness.check(b.getRolloverSelectedIcon(), null);
        harness.check(b.isSelected(), false);
        harness.check(b.getSelectedIcon(), null);
        harness.check(b.getSelectedObjects(), null);
        harness.check(b.getText(), (Object)"");
        harness.check(b.getVerticalAlignment(), 0);
        harness.check(b.getVerticalTextPosition(), 0);
        harness.check(b.getModel() instanceof ButtonModel);
        harness.check(b.getModel() != null);
        harness.check(b.isDefaultCapable(), true);
    }
}

