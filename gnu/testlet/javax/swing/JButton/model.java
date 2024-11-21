/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JButton;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;
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
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        MyJButton b = new MyJButton();
        harness.check(b.getModel().getClass(), DefaultButtonModel.class);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(Action)");
        AbstractAction action = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        MyJButton b = new MyJButton(action);
        harness.check(b.getModel().getClass(), DefaultButtonModel.class);
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(Icon)");
        MyJButton b = new MyJButton(MetalIconFactory.getFileChooserListViewIcon());
        harness.check(b.getModel().getClass(), DefaultButtonModel.class);
    }

    public void testConstructor4(TestHarness harness) {
        harness.checkPoint("(String)");
        MyJButton b = new MyJButton("ABC");
        harness.check(b.getModel().getClass(), DefaultButtonModel.class);
    }

    public void testConstructor5(TestHarness harness) {
        harness.checkPoint("(String, Icon)");
        MyJButton b = new MyJButton("ABC", MetalIconFactory.getFileChooserDetailViewIcon());
        harness.check(b.getModel().getClass(), DefaultButtonModel.class);
    }

    static class MyJButton
    extends JButton {
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
        }
    }
}

