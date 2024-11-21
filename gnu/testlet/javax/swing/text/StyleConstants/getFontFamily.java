/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class getFontFamily
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.getFontFamily(s), (Object)"Monospaced");
        StyleConstants.setFontFamily(s, "XYZ");
        harness.check(StyleConstants.getFontFamily(s), (Object)"XYZ");
        s.removeAttribute(StyleConstants.FontFamily);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        StyleConstants.setFontFamily(parent, "ABC");
        harness.check(StyleConstants.getFontFamily(s), (Object)"ABC");
        boolean pass = false;
        try {
            StyleConstants.getFontFamily(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

