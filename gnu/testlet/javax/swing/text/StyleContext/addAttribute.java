/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleContext;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleContext;

public class addAttribute
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.checkPoint("StyleContext");
        StyleContext sc = new StyleContext();
        SimpleAttributeSet as = new SimpleAttributeSet();
        try {
            sc.addAttribute(as, "key", null);
            h.fail("StyleContext.addAttribute must not accept null value");
        }
        catch (NullPointerException ex) {
            h.check(true);
        }
    }
}

