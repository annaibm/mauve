/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class getSpaceBelow
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.getSpaceBelow(s), 0.0);
        StyleConstants.setSpaceBelow(s, 1.0f);
        harness.check(StyleConstants.getSpaceBelow(s), 1.0);
        s.removeAttribute(StyleConstants.SpaceBelow);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        StyleConstants.setSpaceBelow(parent, 2.0f);
        harness.check(StyleConstants.getSpaceBelow(s), 2.0);
        boolean pass = false;
        try {
            StyleConstants.getSpaceBelow(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

