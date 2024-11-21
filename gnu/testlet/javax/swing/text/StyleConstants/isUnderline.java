/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class isUnderline
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.isUnderline(s), false);
        StyleConstants.setUnderline(s, true);
        harness.check(StyleConstants.isUnderline(s), true);
        s.removeAttribute(StyleConstants.Underline);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        StyleConstants.setUnderline(parent, true);
        harness.check(StyleConstants.isUnderline(s), true);
        boolean pass = false;
        try {
            StyleConstants.isUnderline(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

