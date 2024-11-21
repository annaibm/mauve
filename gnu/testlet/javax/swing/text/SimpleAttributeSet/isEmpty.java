/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class isEmpty
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getAttributeCount()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(s.isEmpty(), true);
        s.addAttribute("X1", "Y1");
        harness.check(s.isEmpty(), false);
        s.removeAttribute("X1");
        harness.check(s.isEmpty(), true);
        SimpleAttributeSet sParent = new SimpleAttributeSet();
        s.setResolveParent(sParent);
        harness.check(s.isEmpty(), false);
        sParent.addAttribute("X2", "Y2");
        harness.check(s.isEmpty(), false);
    }
}

