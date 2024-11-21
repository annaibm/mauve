/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleContext;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.StyleContext;

public class NamedStyleSetResolveParent
implements Testlet {
    @Override
    public void test(TestHarness h) {
        h.checkPoint("StyleContext.NamedStyle");
        StyleContext sc = new StyleContext();
        try {
            StyleContext styleContext = sc;
            styleContext.getClass();
            StyleContext.NamedStyle ns = new StyleContext.NamedStyle(styleContext, "key", null);
            ns.setResolveParent(null);
            h.check(true);
        }
        catch (NullPointerException ex) {
            h.fail("StyledContext.NamedValue.setResolveParent() must accept null values");
        }
    }
}

