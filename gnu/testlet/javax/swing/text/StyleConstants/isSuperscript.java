/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class isSuperscript
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.isSuperscript(s), false);
        StyleConstants.setSuperscript(s, true);
        harness.check(StyleConstants.isSuperscript(s), true);
        s.removeAttribute(StyleConstants.Superscript);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        StyleConstants.setSuperscript(parent, true);
        harness.check(StyleConstants.isSuperscript(s), true);
        boolean pass = false;
        try {
            StyleConstants.isSuperscript(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

