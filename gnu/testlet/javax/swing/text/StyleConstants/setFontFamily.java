/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class setFontFamily
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setFontFamily(s, "F1");
        harness.check(StyleConstants.getFontFamily(s), (Object)"F1");
        boolean pass = false;
        try {
            StyleConstants.setFontFamily(s, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            StyleConstants.setFontFamily(null, "XYZ");
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

