/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList.AccessibleJList.AccessibleJListChild;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JList.AccessibleJList.TestList;
import javax.accessibility.AccessibleComponent;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;

public class isVisible
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyTestList l = new MyTestList(new String[]{"item"});
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        AccessibleComponent child = (AccessibleComponent)((Object)al.getAccessibleChild(0));
        l.visible = true;
        harness.check(child.isVisible(), true);
        l.visible = false;
        harness.check(child.isVisible(), true);
        harness.check(l.isVisible(), false);
        child.setVisible(true);
        harness.check(child.isVisible(), true);
        child.setVisible(false);
        harness.check(child.isVisible(), true);
        AccessibleContext ctx = (AccessibleContext)((Object)child);
        l.first = 0;
        l.last = 0;
        harness.check(child.isVisible(), true);
        AccessibleStateSet states = ctx.getAccessibleStateSet();
        harness.check(states.contains(AccessibleState.VISIBLE));
        l.first = 1;
        l.last = 1;
        harness.check(child.isVisible(), false);
        states = ctx.getAccessibleStateSet();
        harness.check(!states.contains(AccessibleState.VISIBLE));
    }

    class MyTestList
    extends TestList {
        boolean visible;
        int first;
        int last;

        MyTestList(Object[] items) {
            super(items);
        }

        @Override
        public boolean isVisible() {
            return this.visible;
        }

        @Override
        public int getLastVisibleIndex() {
            return this.last;
        }

        @Override
        public int getFirstVisibleIndex() {
            return this.first;
        }
    }
}

