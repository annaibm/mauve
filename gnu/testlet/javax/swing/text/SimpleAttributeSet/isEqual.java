/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class isEqual
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("isEqual()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(s.isEqual(SimpleAttributeSet.EMPTY), true);
        harness.check(SimpleAttributeSet.EMPTY.isEqual(s), true);
        SimpleAttributeSet s2 = new SimpleAttributeSet();
        s2.addAttribute("XX", "YY");
        harness.check(s.isEqual(s2), false);
        boolean pass = false;
        try {
            s.isEqual(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

