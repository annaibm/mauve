/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class setAlignment
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setAlignment(s, 3);
        harness.check(StyleConstants.getAlignment(s), 3);
        StyleConstants.setAlignment(s, 99);
        harness.check(StyleConstants.getAlignment(s), 99);
        boolean pass = false;
        try {
            StyleConstants.setAlignment(null, 3);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

