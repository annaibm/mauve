/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class getAttributeCount
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getAttributeCount()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(s.getAttributeCount(), 0);
        s.addAttribute("X1", "Y1");
        harness.check(s.getAttributeCount(), 1);
        SimpleAttributeSet sParent = new SimpleAttributeSet();
        s.setResolveParent(sParent);
        harness.check(s.getAttributeCount(), 2);
        sParent.addAttribute("X2", "Y2");
        harness.check(s.getAttributeCount(), 2);
        sParent.addAttribute("X3", "Y3");
        harness.check(s.getAttributeCount(), 2);
        s.addAttribute("X2", "YY2");
        harness.check(s.getAttributeCount(), 3);
    }
}

