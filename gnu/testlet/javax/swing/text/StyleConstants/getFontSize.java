/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class getFontSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.getFontSize(s), 12);
        StyleConstants.setFontSize(s, 14);
        harness.check(StyleConstants.getFontSize(s), 14);
        s.removeAttribute(StyleConstants.FontSize);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        StyleConstants.setFontSize(parent, 16);
        harness.check(StyleConstants.getFontSize(s), 16);
        boolean pass = false;
        try {
            StyleConstants.getFontSize(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

