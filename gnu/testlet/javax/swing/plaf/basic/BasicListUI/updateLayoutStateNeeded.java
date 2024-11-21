/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.plaf.basic.BasicListUI;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicListUI;

public class updateLayoutStateNeeded
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        this.testModelDataChange(harness);
    }

    private void testModelDataChange(TestHarness h) {
        JList l = new JList(new DefaultListModel());
        TestListUI ui = new TestListUI();
        l.setUI(ui);
        ui.maybeUpdateLayoutState();
        h.check(ui.getUpdateLayoutStateNeeded(), 0);
        ((DefaultListModel)l.getModel()).addElement("test");
        h.check(ui.getUpdateLayoutStateNeeded(), 1);
    }

    private class TestListUI
    extends BasicListUI {
        private TestListUI() {
        }

        public int getUpdateLayoutStateNeeded() {
            return this.updateLayoutStateNeeded;
        }

        @Override
        public void maybeUpdateLayoutState() {
            super.maybeUpdateLayoutState();
        }
    }
}

