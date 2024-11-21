/*
 * Decompiled with CFR 0.152.
 */
package gnu.testlet.javax.swing.text.StyleConstants;

import gnu.testlet.TestHarness;
import gnu.testlet.Testlet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.TabSet;
import javax.swing.text.TabStop;

public class getTabSet
implements Testlet {
    @Override
    public void test(TestHarness harness) {
        SimpleAttributeSet s = new SimpleAttributeSet();
        harness.check(StyleConstants.getTabSet(s), null);
        TabStop[] tabs1 = new TabStop[]{new TabStop(8.0f)};
        TabSet ts1 = new TabSet(tabs1);
        StyleConstants.setTabSet(s, ts1);
        harness.check(StyleConstants.getTabSet(s), ts1);
        s.removeAttribute(StyleConstants.TabSet);
        SimpleAttributeSet parent = new SimpleAttributeSet();
        s.setResolveParent(parent);
        TabStop[] tabs2 = new TabStop[]{new TabStop(10.0f)};
        TabSet ts2 = new TabSet(tabs2);
        StyleConstants.setTabSet(parent, ts2);
        harness.check(StyleConstants.getTabSet(s), ts2);
        boolean pass = false;
        try {
            StyleConstants.getTabSet(null);
        }
        catch (NullPointerException e) {
            pass = true;
        }
        harness.check(pass);
    }
}

