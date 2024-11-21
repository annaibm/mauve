/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class setSubscript
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setSubscript(s, true);
        harness.check(StyleConstants.isSubscript(s), true);
        boolean pass = false;
        try {
            StyleConstants.setSubscript(null, true);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

