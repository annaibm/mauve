/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class addAttribute
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("addAttribute()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        s.addAttribute("X1", "Y1");
        harness.check(s.getAttribute("X1"), (Object)"Y1");
        s.addAttribute("X1", "Y1");
        harness.check(s.getAttributeCount(), 1);
        s.addAttribute("X1", "YY1");
        harness.check(s.getAttribute("X1"), (Object)"YY1");
        harness.check(s.getAttributeCount(), 1);
        SimpleAttributeSet sParent = new SimpleAttributeSet();
        sParent.addAttribute("X2", "Y2");
        s.setResolveParent(sParent);
        harness.check(s.getAttributeCount(), 2);
        s.addAttribute("X2", "Y2");
        harness.check(s.getAttribute("X2"), (Object)"Y2");
        harness.check(s.getAttributeCount(), 3);
        s.addAttribute("X2", "Z2");
        harness.check(s.getAttribute("X2"), (Object)"Z2");
        harness.check(s.getAttributeCount(), 3);
        harness.check(sParent.getAttribute("X2"), (Object)"Y2");
        harness.check(sParent.getAttributeCount(), 1);
        boolean pass = false;
        try {
            s.addAttribute(null, "XX");
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            s.addAttribute("X2", null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

