/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList.AccessibleJList.AccessibleJListChild;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JList.AccessibleJList.TestList;
import javax.accessibility.AccessibleComponent;

public class isEnabled
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestList l = new TestList(new String[]{"item"});
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        l.setEnabled(true);
        AccessibleComponent child = (AccessibleComponent)((Object)al.getAccessibleChild(0));
        harness.check(child.isEnabled(), true);
        l.setEnabled(false);
        harness.check(child.isEnabled(), false);
    }
}

