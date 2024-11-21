/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class setStrikeThrough
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setStrikeThrough(s, true);
        harness.check(StyleConstants.isStrikeThrough(s), true);
        boolean pass = false;
        try {
            StyleConstants.setStrikeThrough(null, true);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

