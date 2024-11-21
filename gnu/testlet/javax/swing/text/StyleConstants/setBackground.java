/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class setBackground
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setBackground(s, Color.blue);
        harness.check(StyleConstants.getBackground(s), Color.blue);
        boolean pass = false;
        try {
            StyleConstants.setBackground(s, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            StyleConstants.setBackground(null, Color.red);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

