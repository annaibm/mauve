/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenu;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultButtonModel;
import javax.swing.Icon;
import javax.swing.JMenu;

public class model
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testConstructor1(harness);
        this.testConstructor2(harness);
        this.testConstructor3(harness);
        this.testConstructor4(harness);
    }

    public void testConstructor1(TestHarness harness) {
        harness.checkPoint("()");
        MyJMenu b = new MyJMenu();
        harness.check(b.getModel().getClass(), DefaultButtonModel.class);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(Action)");
        AbstractAction action = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        MyJMenu b = new MyJMenu(action);
        harness.check(b.getModel().getClass(), DefaultButtonModel.class);
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(String)");
        MyJMenu b = new MyJMenu("ABC");
        harness.check(b.getModel().getClass(), DefaultButtonModel.class);
    }

    public void testConstructor4(TestHarness harness) {
        harness.checkPoint("(String, boolean)");
        MyJMenu b = new MyJMenu("ABC", false);
        harness.check(b.getModel().getClass(), DefaultButtonModel.class);
    }

    static class MyJMenu
    extends JMenu {
        public MyJMenu() {
        }

        public MyJMenu(Action action) {
            super(action);
        }

        public MyJMenu(String text2) {
            super(text2);
        }

        public MyJMenu(String text2, boolean selected) {
            super(text2, selected);
        }

        @Override
        public void init(String text2, Icon icon) {
        }
    }
}

