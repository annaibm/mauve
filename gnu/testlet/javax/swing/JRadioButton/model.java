/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JRadioButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalIconFactory;

public class model
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
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        MyJRadioButton b = new MyJRadioButton();
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(Action)");
        AbstractAction action = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        MyJRadioButton b = new MyJRadioButton(action);
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(Icon)");
        MyJRadioButton b = new MyJRadioButton(MetalIconFactory.getFileChooserListViewIcon());
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor4(TestHarness harness) {
        harness.checkPoint("(Icon, boolean)");
        MyJRadioButton b = new MyJRadioButton(MetalIconFactory.getFileChooserListViewIcon(), false);
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor5(TestHarness harness) {
        harness.checkPoint("(String)");
        MyJRadioButton b = new MyJRadioButton("ABC");
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor6(TestHarness harness) {
        harness.checkPoint("(String, boolean)");
        MyJRadioButton b = new MyJRadioButton("ABC", false);
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor7(TestHarness harness) {
        harness.checkPoint("(String, Icon)");
        MyJRadioButton b = new MyJRadioButton("ABC", MetalIconFactory.getFileChooserDetailViewIcon());
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor8(TestHarness harness) {
        harness.checkPoint("(String, Icon, boolean)");
        MyJRadioButton b = new MyJRadioButton("ABC", MetalIconFactory.getFileChooserDetailViewIcon(), false);
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    static class MyJRadioButton
    extends JRadioButton {
        public MyJRadioButton() {
        }

        public MyJRadioButton(Action action) {
            super(action);
        }

        public MyJRadioButton(Icon icon) {
            super(icon);
        }

        public MyJRadioButton(Icon icon, boolean selected) {
            super(icon, selected);
        }

        public MyJRadioButton(String text2) {
            super(text2);
        }

        public MyJRadioButton(String text2, boolean selected) {
            super(text2, selected);
        }

        public MyJRadioButton(String text2, Icon icon) {
            super(text2, icon);
        }

        public MyJRadioButton(String text2, Icon icon, boolean selected) {
            super(text2, icon, selected);
        }

        @Override
        public void init(String text2, Icon icon) {
        }
    }
}

