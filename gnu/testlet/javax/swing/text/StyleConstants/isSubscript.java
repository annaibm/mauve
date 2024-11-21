/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class isSubscript
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.isSubscript(s), false);
        StyleConstants.setSubscript(s, true);
        harness.check(StyleConstants.isSubscript(s), true);
        s.removeAttribute(StyleConstants.Subscript);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        StyleConstants.setSubscript(parent, true);
        harness.check(StyleConstants.isSubscript(s), true);
        boolean pass = false;
        try {
            StyleConstants.isSubscript(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

