/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList.AccessibleJList.AccessibleJListChild;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JList.AccessibleJList.TestList;
import java.awt.Color;
import javax.accessibility.AccessibleComponent;

public class setForeground
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestList l = new TestList(new String[]{"item"});
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        AccessibleComponent child = (AccessibleComponent)((Object)al.getAccessibleChild(0));
        Color listForeground = l.getForeground();
        child.setForeground(Color.RED);
        harness.check(l.getForeground(), listForeground);
        child.setForeground(Color.GREEN);
        harness.check(l.getForeground(), listForeground);
    }
}

