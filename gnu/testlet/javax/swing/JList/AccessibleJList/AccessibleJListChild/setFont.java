/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList.AccessibleJList.AccessibleJListChild;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JList.AccessibleJList.TestList;
import java.awt.Font;
import javax.accessibility.AccessibleComponent;

public class setFont
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestList l = new TestList(new String[]{"item"});
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        AccessibleComponent child = (AccessibleComponent)((Object)al.getAccessibleChild(0));
        Font font = l.getFont();
        child.setFont(new Font("Dialog", 0, 16));
        harness.check(l.getFont(), font);
        child.setFont(new Font("Dialog", 1, 12));
        harness.check(l.getFont(), font);
    }
}

