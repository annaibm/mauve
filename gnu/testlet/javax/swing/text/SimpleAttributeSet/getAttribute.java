/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.SimpleAttributeSet;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;

public class getAttribute
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        harness.checkPoint("getAttribute()");
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(s.getAttribute("X1"), null);
        s.addAttribute("X1", "Y1");
        harness.check(s.getAttribute("X1"), (Object)"Y1");
        SimpleAttributeSet sParent = new SimpleAttributeSet();
        sParent.addAttribute("X2", "Y2");
        s.setResolveParent(sParent);
        harness.check(s.getAttribute("X2"), (Object)"Y2");
        s.addAttribute("X2", "YY2");
        harness.check(s.getAttribute("X2"), (Object)"YY2");
        boolean pass = false;
        try {
            s.getAttribute(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

