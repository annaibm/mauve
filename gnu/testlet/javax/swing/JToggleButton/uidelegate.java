/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JToggleButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JToggleButton;
import javax.swing.plaf.metal.MetalIconFactory;

public class uidelegate
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
        MyJToggleButton b = new MyJToggleButton();
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(Action)");
        AbstractAction action = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        MyJToggleButton b = new MyJToggleButton(action);
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(Icon)");
        MyJToggleButton b = new MyJToggleButton(MetalIconFactory.getFileChooserListViewIcon());
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor4(TestHarness harness) {
        harness.checkPoint("(Icon, boolean)");
        MyJToggleButton b = new MyJToggleButton(MetalIconFactory.getFileChooserListViewIcon(), false);
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor5(TestHarness harness) {
        harness.checkPoint("(String)");
        MyJToggleButton b = new MyJToggleButton("ABC");
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor6(TestHarness harness) {
        harness.checkPoint("(String, boolean)");
        MyJToggleButton b = new MyJToggleButton("ABC", false);
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor7(TestHarness harness) {
        harness.checkPoint("(String, Icon)");
        MyJToggleButton b = new MyJToggleButton("ABC", MetalIconFactory.getFileChooserDetailViewIcon());
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor8(TestHarness harness) {
        harness.checkPoint("(String, Icon, boolean)");
        MyJToggleButton b = new MyJToggleButton("ABC", MetalIconFactory.getFileChooserDetailViewIcon(), false);
        harness.check(b.getModel().getClass(), JToggleButton.ToggleButtonModel.class);
    }

    static class MyJToggleButton
    extends JToggleButton {
        public boolean initCalled;
        public boolean updateUICalledAfterInitCalled;

        public MyJToggleButton() {
        }

        public MyJToggleButton(Action action) {
            super(action);
        }

        public MyJToggleButton(Icon icon) {
            super(icon);
        }

        public MyJToggleButton(Icon icon, boolean selected) {
            super(icon, selected);
        }

        public MyJToggleButton(String text2) {
            super(text2);
        }

        public MyJToggleButton(String text2, boolean selected) {
            super(text2, selected);
        }

        public MyJToggleButton(String text2, Icon icon) {
            super(text2, icon);
        }

        public MyJToggleButton(String text2, Icon icon, boolean selected) {
            super(text2, icon, selected);
        }

        @Override
        public void init(String text2, Icon icon) {
            this.initCalled = true;
            super.init(text2, icon);
        }

        @Override
        public void updateUI() {
            this.updateUICalledAfterInitCalled = this.initCalled;
            super.updateUI();
        }
    }
}

