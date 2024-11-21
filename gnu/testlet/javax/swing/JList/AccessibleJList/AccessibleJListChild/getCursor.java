/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.JList.AccessibleJList.AccessibleJListChild;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import gnu.testlet.javax.swing.JList.AccessibleJList.TestList;
import java.awt.Cursor;
import javax.accessibility.AccessibleComponent;

public class getCursor
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        TestList l = new TestList(new String[]{"item"});
        TestList.AccessibleTestList al = (TestList.AccessibleTestList)l.getAccessibleContext();
        Cursor cursor1 = Cursor.getPredefinedCursor(1);
        Cursor cursor2 = Cursor.getPredefinedCursor(12);
        l.setCursor(cursor1);
        harness.check(l.getCursor(), cursor1);
        AccessibleComponent child = (AccessibleComponent)((Object)al.getAccessibleChild(0));
        harness.check(child.getCursor(), Cursor.getDefaultCursor());
        l.setCursor(cursor2);
        harness.check(child.getCursor(), Cursor.getDefaultCursor());
        child.setCursor(cursor1);
        harness.check(child.getCursor(), cursor1);
    }
}

