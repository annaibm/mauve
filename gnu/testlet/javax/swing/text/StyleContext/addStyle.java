/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleContext;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.StyleContext;

public class addStyle
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.checkPoint("StyleContext.addStyle");
        StyleContext sc = new StyleContext();
        try {
            sc.addStyle("key", null);
            h.check(true);
        }
        catch (NullPointerException ex) {
            h.fail("StyleContext.addStyle must accept null value");
        }
    }
}

