/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList.AccessibleJList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JList.AccessibleJList.TestList;
import javax.accessibility.AccessibleRole;

public class getAccessibleRole
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestList l = new TestList();
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        AccessibleRole role = al.getAccessibleRole();
        harness.check(role, AccessibleRole.LIST);
    }
}

