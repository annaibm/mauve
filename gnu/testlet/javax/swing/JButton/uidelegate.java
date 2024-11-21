/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
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
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        MyJButton b = new MyJButton();
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(Action)");
        AbstractAction action = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        MyJButton b = new MyJButton(action);
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(Icon)");
        MyJButton b = new MyJButton(MetalIconFactory.getFileChooserListViewIcon());
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor4(TestHarness harness) {
        harness.checkPoint("(String)");
        MyJButton b = new MyJButton("ABC");
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor5(TestHarness harness) {
        harness.checkPoint("(String, Icon)");
        MyJButton b = new MyJButton("ABC", MetalIconFactory.getFileChooserDetailViewIcon());
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    static class MyJButton
    extends JButton {
        public boolean initCalled;
        public boolean updateUICalledAfterInitCalled;

        public MyJButton() {
        }

        public MyJButton(Action action) {
            super(action);
        }

        public MyJButton(Icon icon) {
            super(icon);
        }

        public MyJButton(String text2) {
            super(text2);
        }

        public MyJButton(String text2, Icon icon) {
            super(text2, icon);
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

