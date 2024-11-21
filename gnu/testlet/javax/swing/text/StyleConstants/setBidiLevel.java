/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class setBidiLevel
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setBidiLevel(s, 1);
        harness.check(StyleConstants.getBidiLevel(s), 1);
        boolean pass = false;
        try {
            StyleConstants.setBidiLevel(null, 2);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

