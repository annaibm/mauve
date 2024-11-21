/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class getAlignment
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.getAlignment(s), 0);
        StyleConstants.setAlignment(s, 3);
        harness.check(StyleConstants.getAlignment(s), 3);
        s.removeAttribute(StyleConstants.Alignment);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        StyleConstants.setAlignment(parent, 3);
        harness.check(StyleConstants.getAlignment(s), 3);
        boolean pass = false;
        try {
            StyleConstants.getAlignment(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

