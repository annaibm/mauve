/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class setFontSize
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setFontSize(s, 14);
        harness.check(StyleConstants.getFontSize(s), 14);
        boolean pass = false;
        try {
            StyleConstants.setFontSize(null, 2);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

