/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JLabel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class setComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        JLabel comp1 = new JLabel("XYZ");
        StyleConstants.setComponent(s, comp1);
        harness.check(StyleConstants.getComponent(s), comp1);
        boolean pass = false;
        try {
            StyleConstants.setComponent(s, null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
        pass = false;
        try {
            StyleConstants.setComponent(null, comp1);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

