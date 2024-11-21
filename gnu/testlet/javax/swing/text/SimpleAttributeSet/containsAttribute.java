/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class containsAttribute
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("containsAttribute()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(s.containsAttribute("X1", "Y1"), false);
        s.addAttribute("X1", "Y1");
        harness.check(s.containsAttribute("X1", "Y1"), true);
        harness.check(s.containsAttribute("X1", "Y2"), false);
        harness.check(s.containsAttribute("X2", "Y1"), false);
        SimpleAttributeSet sParent = new SimpleAttributeSet();
        sParent.addAttribute("X2", "Y2");
        s.setResolveParent(sParent);
        harness.check(s.containsAttribute("X1", "Y1"), true);
        harness.check(s.containsAttribute("X2", "Y2"), true);
        s.addAttribute("X2", "ZZ");
        harness.check(s.containsAttribute("X2", "ZZ"), true);
        harness.check(s.containsAttribute("X2", "Y2"), false);
        boolean pass = false;
        try {
            s.containsAttribute(null, "XX");
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            s.containsAttribute("X2", null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            s.containsAttribute("XXX", null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

