/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.JLabel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class getComponent
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.getComponent(s), null);
        JLabel comp = new JLabel("Label1");
        StyleConstants.setComponent(s, comp);
        harness.check(StyleConstants.getComponent(s), comp);
        s.removeAttribute(StyleConstants.ComponentAttribute);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        JLabel comp2 = new JLabel("Label2");
        StyleConstants.setComponent(parent, comp2);
        harness.check(StyleConstants.getComponent(s), comp2);
        boolean pass = false;
        try {
            StyleConstants.getComponent(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

