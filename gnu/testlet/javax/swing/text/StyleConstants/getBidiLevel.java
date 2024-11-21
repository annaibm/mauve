/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class getBidiLevel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.getBidiLevel(s), 0);
        StyleConstants.setBidiLevel(s, 1);
        harness.check(StyleConstants.getBidiLevel(s), 1);
        s.removeAttribute(StyleConstants.BidiLevel);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        StyleConstants.setBidiLevel(parent, 2);
        harness.check(StyleConstants.getBidiLevel(s), 2);
        boolean pass = false;
        try {
            StyleConstants.getBidiLevel(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

