/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import java.awt.Color;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class getBackground
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.getBackground(s), Color.black);
        StyleConstants.setBackground(s, Color.red);
        harness.check(StyleConstants.getBackground(s), Color.red);
        s.removeAttribute(StyleConstants.Background);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        StyleConstants.setBackground(parent, Color.yellow);
        harness.check(StyleConstants.getBackground(s), Color.yellow);
        boolean pass = false;
        try {
            StyleConstants.getBackground(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

