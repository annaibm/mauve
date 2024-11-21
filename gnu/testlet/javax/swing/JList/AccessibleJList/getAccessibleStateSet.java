/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList.AccessibleJList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JList.AccessibleJList.TestList;
import javax.accessibility.AccessibleState;
import javax.accessibility.AccessibleStateSet;

public class getAccessibleStateSet
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestList l = new TestList();
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        l.setSelectionMode(2);
        AccessibleStateSet ss = al.getAccessibleStateSet();
        harness.check(ss.contains(AccessibleState.MULTISELECTABLE));
        l.setSelectionMode(1);
        ss = al.getAccessibleStateSet();
        harness.check(ss.contains(AccessibleState.MULTISELECTABLE));
        l.setSelectionMode(0);
        ss = al.getAccessibleStateSet();
        harness.check(!ss.contains(AccessibleState.MULTISELECTABLE));
    }
}

