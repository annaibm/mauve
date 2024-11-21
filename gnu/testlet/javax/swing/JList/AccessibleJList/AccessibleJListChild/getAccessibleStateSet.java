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

public class getAccessibleStateSet
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestList l = new TestList(new String[]{"item"});
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        AccessibleContext child = (AccessibleContext)((Object)al.getAccessibleChild(0));
        AccessibleComponent childC = (AccessibleComponent)((Object)child);
        AccessibleStateSet states = child.getAccessibleStateSet();
        harness.check(states.contains(AccessibleState.TRANSIENT));
    }
}

