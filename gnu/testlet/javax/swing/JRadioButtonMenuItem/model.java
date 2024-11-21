/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JRadioButtonMenuItem;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JRadioButtonMenuItem;
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
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        MyJRadioButtonMenuItem b = new MyJRadioButtonMenuItem();
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(Action)");
        AbstractAction action = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        MyJRadioButtonMenuItem b = new MyJRadioButtonMenuItem(action);
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(Icon)");
        MyJRadioButtonMenuItem b = new MyJRadioButtonMenuItem(MetalIconFactory.getFileChooserListViewIcon());
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor4(TestHarness harness) {
        harness.checkPoint("(String)");
        MyJRadioButtonMenuItem b = new MyJRadioButtonMenuItem("ABC");
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor5(TestHarness harness) {
        harness.checkPoint("(String, boolean)");
        MyJRadioButtonMenuItem b = new MyJRadioButtonMenuItem("ABC", false);
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor6(TestHarness harness) {
        harness.checkPoint("(String, Icon)");
        MyJRadioButtonMenuItem b = new MyJRadioButtonMenuItem("ABC", MetalIconFactory.getFileChooserDetailViewIcon());
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor7(TestHarness harness) {
        harness.checkPoint("(String, Icon, boolean)");
        MyJRadioButtonMenuItem b = new MyJRadioButtonMenuItem("ABC", MetalIconFactory.getFileChooserDetailViewIcon(), false);
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    static class MyJRadioButtonMenuItem
    extends JRadioButtonMenuItem {
        public MyJRadioButtonMenuItem() {
        }

        public MyJRadioButtonMenuItem(Action action) {
            super(action);
        }

        public MyJRadioButtonMenuItem(Icon icon) {
            super(icon);
        }

        public MyJRadioButtonMenuItem(String text2) {
            super(text2);
        }

        public MyJRadioButtonMenuItem(String text2, boolean selected) {
            super(text2, selected);
        }

        public MyJRadioButtonMenuItem(String text2, Icon icon) {
            super(text2, icon);
        }

        public MyJRadioButtonMenuItem(String text2, Icon icon, boolean selected) {
            super(text2, icon, selected);
        }

        @Override
        public void init(String text2, Icon icon) {
        }
    }
}

