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

public class isShowing
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyTestList l = new MyTestList(new String[]{"item"});
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        AccessibleComponent child = (AccessibleComponent)((Object)al.getAccessibleChild(0));
        AccessibleContext ctx = (AccessibleContext)((Object)child);
        l.first = 0;
        l.last = 0;
        l.showing = true;
        harness.check(child.isShowing(), true);
        AccessibleStateSet states = ctx.getAccessibleStateSet();
        harness.check(states.contains(AccessibleState.SHOWING));
        l.showing = false;
        harness.check(child.isShowing(), false);
        states = ctx.getAccessibleStateSet();
        harness.check(!states.contains(AccessibleState.SHOWING));
        l.first = 1;
        l.last = 1;
        l.showing = true;
        harness.check(child.isShowing(), false);
        states = ctx.getAccessibleStateSet();
        harness.check(!states.contains(AccessibleState.SHOWING));
        l.showing = false;
        harness.check(child.isShowing(), false);
        states = ctx.getAccessibleStateSet();
        harness.check(!states.contains(AccessibleState.SHOWING));
    }

    class MyTestList
    extends TestList {
        boolean showing;
        int first;
        int last;

        MyTestList(Object[] items) {
            super(items);
        }

        @Override
        public boolean isShowing() {
            return this.showing;
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

