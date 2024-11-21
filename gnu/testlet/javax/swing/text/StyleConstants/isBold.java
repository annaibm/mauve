/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class isBold
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.isBold(s), false);
        StyleConstants.setBold(s, true);
        harness.check(StyleConstants.isBold(s), true);
        s.removeAttribute(StyleConstants.Bold);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        StyleConstants.setBold(parent, true);
        harness.check(StyleConstants.isBold(s), true);
        boolean pass = false;
        try {
            StyleConstants.isBold(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

