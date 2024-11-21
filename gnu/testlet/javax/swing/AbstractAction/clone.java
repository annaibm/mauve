/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractAction;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.AbstractAction.MyAction;

public class clone
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyAction a1 = new MyAction("X");
        MyAction a2 = null;
        try {
            a2 = (MyAction)a1.clone();
        }
        catch (CloneNotSupportedException e) {
            harness.check(false);
        }
        harness.check(a1 != a2);
        harness.check(a1.getClass().equals(a2.getClass()));
        harness.check(a2.getValue("Name"), (Object)"X");
    }
}

