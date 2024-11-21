/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList.AccessibleJList.AccessibleJListChild;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JList.AccessibleJList.TestList;
import java.awt.Font;
import javax.accessibility.AccessibleComponent;

public class getFont
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestList l = new TestList(new String[]{"item"});
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        Font font1 = new Font("Dialog", 0, 16);
        Font font2 = new Font("Dialog", 1, 12);
        l.setFont(font1);
        AccessibleComponent child = (AccessibleComponent)((Object)al.getAccessibleChild(0));
        harness.check(child.getFont(), font1);
        l.setFont(font2);
        harness.check(child.getFont(), font2);
    }
}

