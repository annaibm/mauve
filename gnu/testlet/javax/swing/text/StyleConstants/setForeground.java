/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class setForeground
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setForeground(s, Color.blue);
        harness.check(StyleConstants.getForeground(s), Color.blue);
        boolean pass = false;
        try {
            StyleConstants.setForeground(s, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            StyleConstants.setForeground(null, Color.red);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

