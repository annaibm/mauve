/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractAction;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.AbstractAction.MyAction;
import gnu.testlet.javax.swing.AbstractAction.MyPropertyChangeListener;

public class setEnabled
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyPropertyChangeListener listener = new MyPropertyChangeListener();
        MyAction a1 = new MyAction();
        a1.addPropertyChangeListener(listener);
        harness.check(a1.isEnabled());
        harness.check(!listener.getChange());
        a1.setEnabled(true);
        harness.check(!listener.getChange());
        a1.setEnabled(false);
        harness.check(listener.getChange());
    }
}

