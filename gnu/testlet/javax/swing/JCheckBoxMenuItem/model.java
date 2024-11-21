/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JCheckBoxMenuItem;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JCheckBoxMenuItem;
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
        MyJCheckBoxMenuItem b = new MyJCheckBoxMenuItem();
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(Action)");
        AbstractAction action = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        MyJCheckBoxMenuItem b = new MyJCheckBoxMenuItem(action);
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(Icon)");
        MyJCheckBoxMenuItem b = new MyJCheckBoxMenuItem(MetalIconFactory.getFileChooserListViewIcon());
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor4(TestHarness harness) {
        harness.checkPoint("(String)");
        MyJCheckBoxMenuItem b = new MyJCheckBoxMenuItem("ABC");
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor5(TestHarness harness) {
        harness.checkPoint("(String, boolean)");
        MyJCheckBoxMenuItem b = new MyJCheckBoxMenuItem("ABC", false);
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor6(TestHarness harness) {
        harness.checkPoint("(String, Icon)");
        MyJCheckBoxMenuItem b = new MyJCheckBoxMenuItem("ABC", MetalIconFactory.getFileChooserDetailViewIcon());
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    public void testConstructor7(TestHarness harness) {
        harness.checkPoint("(String, Icon, boolean)");
        MyJCheckBoxMenuItem b = new MyJCheckBoxMenuItem("ABC", MetalIconFactory.getFileChooserDetailViewIcon(), false);
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    static class MyJCheckBoxMenuItem
    extends JCheckBoxMenuItem {
        public MyJCheckBoxMenuItem() {
        }

        public MyJCheckBoxMenuItem(Action action) {
            super(action);
        }

        public MyJCheckBoxMenuItem(Icon icon) {
            super(icon);
        }

        public MyJCheckBoxMenuItem(String text2) {
            super(text2);
        }

        public MyJCheckBoxMenuItem(String text2, boolean selected) {
            super(text2, selected);
        }

        public MyJCheckBoxMenuItem(String text2, Icon icon) {
            super(text2, icon);
        }

        public MyJCheckBoxMenuItem(String text2, Icon icon, boolean selected) {
            super(text2, icon, selected);
        }

        @Override
        public void init(String text2, Icon icon) {
        }
    }
}

