/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class getForeground
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.getForeground(s), Color.black);
        StyleConstants.setForeground(s, Color.red);
        harness.check(StyleConstants.getForeground(s), Color.red);
        s.removeAttribute(StyleConstants.Foreground);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        StyleConstants.setForeground(parent, Color.yellow);
        harness.check(StyleConstants.getForeground(s), Color.yellow);
        boolean pass = false;
        try {
            StyleConstants.getForeground(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

