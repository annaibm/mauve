/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class removeAttribute
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("removeAttribute()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        s.removeAttribute("X1");
        s.addAttribute("X1", "Y1");
        harness.check(s.getAttribute("X1"), (Object)"Y1");
        s.removeAttribute("X2");
        harness.check(s.getAttributeCount(), 1);
        s.removeAttribute("X1");
        harness.check(s.getAttribute("X1"), null);
        SimpleAttributeSet sParent = new SimpleAttributeSet();
        sParent.addAttribute("XX", "YY");
        s.setResolveParent(sParent);
        harness.check(sParent.getAttributeCount(), 1);
        s.removeAttribute("XX");
        harness.check(sParent.getAttribute("XX"), (Object)"YY");
        boolean pass = false;
        try {
            s.removeAttribute(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

