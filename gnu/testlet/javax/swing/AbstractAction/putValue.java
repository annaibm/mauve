/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.AbstractAction;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.AbstractAction.MyAction;

public class putValue
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        MyAction a1 = new MyAction();
        a1.putValue("Name", "Name");
        harness.check(a1.getValue("Name"), (Object)"Name");
        a1.putValue("Name", "Name2");
        harness.check(a1.getValue("Name"), (Object)"Name2");
        a1.putValue("Name", null);
        harness.check(a1.getValue("Name"), null);
    }
}

