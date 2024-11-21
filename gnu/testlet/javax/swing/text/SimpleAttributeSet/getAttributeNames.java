/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.util.Enumeration;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;

public class getAttributeNames
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getAttributeNames()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        Enumeration<?> e = s.getAttributeNames();
        harness.check(e.hasMoreElements(), false);
        s.addAttribute("X1", "Y1");
        e = s.getAttributeNames();
        harness.check(e.hasMoreElements(), true);
        harness.check(e.nextElement(), (Object)"X1");
        harness.check(e.hasMoreElements(), false);
        SimpleAttributeSet sParent = new SimpleAttributeSet();
        s.setResolveParent(sParent);
        s.removeAttribute("X1");
        e = s.getAttributeNames();
        harness.check(e.hasMoreElements(), true);
        harness.check(e.nextElement(), AttributeSet.ResolveAttribute);
        harness.check(e.hasMoreElements(), false);
    }
}

