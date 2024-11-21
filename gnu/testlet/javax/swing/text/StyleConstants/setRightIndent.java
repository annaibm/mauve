/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class setRightIndent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setRightIndent(s, 4.0f);
        harness.check(StyleConstants.getRightIndent(s), 4.0);
        boolean pass = false;
        try {
            StyleConstants.setRightIndent(null, 2.0f);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

