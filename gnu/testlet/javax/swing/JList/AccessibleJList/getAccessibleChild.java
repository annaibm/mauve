/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList.AccessibleJList;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JList.AccessibleJList.TestList;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleComponent;

public class getAccessibleChild
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestList l = new TestList(new String[]{"child"});
        harness.check(l.getModel().getSize(), 1);
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        Accessible child1 = al.getAccessibleChild(0);
        harness.check(child1 != null);
        harness.check(child1 instanceof AccessibleComponent);
        Accessible child2 = al.getAccessibleChild(1);
        harness.check(child2, null);
    }
}

