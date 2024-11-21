/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList.AccessibleJList.AccessibleJListChild;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JList.AccessibleJList.TestList;
import java.awt.Color;
import javax.accessibility.AccessibleComponent;

public class setBackground
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestList l = new TestList(new String[]{"item"});
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        AccessibleComponent child = (AccessibleComponent)((Object)al.getAccessibleChild(0));
        Color listBackground = l.getBackground();
        child.setBackground(Color.RED);
        harness.check(l.getBackground(), listBackground);
        child.setBackground(Color.GREEN);
        harness.check(l.getBackground(), listBackground);
    }
}

