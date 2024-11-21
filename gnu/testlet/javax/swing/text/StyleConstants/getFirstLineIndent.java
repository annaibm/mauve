/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class getFirstLineIndent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.getFirstLineIndent(s), 0.0);
        StyleConstants.setFirstLineIndent(s, 1.0f);
        harness.check(StyleConstants.getFirstLineIndent(s), 1.0);
        s.removeAttribute(StyleConstants.FirstLineIndent);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        StyleConstants.setFirstLineIndent(parent, 2.0f);
        harness.check(StyleConstants.getFirstLineIndent(s), 2.0);
        boolean pass = false;
        try {
            StyleConstants.getFirstLineIndent(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

