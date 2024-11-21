/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JMenu;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JMenu;

public class uidelegate
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
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor2(TestHarness harness) {
        harness.checkPoint("(Action)");
        AbstractAction action = new AbstractAction(){

            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        MyJMenu b = new MyJMenu(action);
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor3(TestHarness harness) {
        harness.checkPoint("(String)");
        MyJMenu b = new MyJMenu("ABC");
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    public void testConstructor4(TestHarness harness) {
        harness.checkPoint("(String, boolean)");
        MyJMenu b = new MyJMenu("ABC", false);
        harness.check(b.updateUICalledAfterInitCalled, true);
    }

    static class MyJMenu
    extends JMenu {
        public boolean initCalled;
        public boolean updateUICalledAfterInitCalled;

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

