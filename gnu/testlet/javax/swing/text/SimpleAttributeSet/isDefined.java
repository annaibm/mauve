/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;

public class isDefined
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("isDefined()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(s.isDefined("X1"), false);
        s.addAttribute("X1", "Y1");
        harness.check(s.isDefined("X1"), true);
        s.removeAttribute("X1");
        harness.check(s.isDefined("X1"), false);
        SimpleAttributeSet sParent = new SimpleAttributeSet();
        sParent.addAttribute("X2", "Y2");
        s.setResolveParent(sParent);
        harness.check(s.isDefined("X2"), false);
        harness.check(s.isDefined(AttributeSet.ResolveAttribute), true);
        boolean pass = false;
        try {
            s.isDefined(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

