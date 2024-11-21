/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList.AccessibleJList.AccessibleJListChild;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JList.AccessibleJList.TestList;
import java.awt.Cursor;
import javax.accessibility.AccessibleComponent;

public class setCursor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestList l = new TestList(new String[]{"item"});
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        AccessibleComponent child = (AccessibleComponent)((Object)al.getAccessibleChild(0));
        Cursor cursor = l.getCursor();
        child.setCursor(Cursor.getPredefinedCursor(1));
        harness.check(l.getCursor(), cursor);
        harness.check(child.getCursor(), Cursor.getPredefinedCursor(1));
        child.setCursor(Cursor.getPredefinedCursor(12));
        harness.check(l.getCursor(), cursor);
        harness.check(child.getCursor(), Cursor.getPredefinedCursor(12));
    }
}

